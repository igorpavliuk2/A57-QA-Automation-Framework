package com.qa.koel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.HashMap;
import java.util.UUID;

public class BaseTest {
    public WebDriver driver = null;
    public WebDriverWait wait;
    public String url = "https://qa.koel.app/";
    public String email = "igor.pavliuk@testpro.io";
    public String password = "1q2w3e4R";
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Parameters({"BaseURL"})
    @BeforeMethod
    public void setupDriver(String BaseURL) throws MalformedURLException  {
        threadDriver.set(pickDriver(System.getProperty("browserName")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        getDriver().get(BaseURL);


    }

    @AfterMethod
    public void tearDown() {
        threadDriver.get().close();
        threadDriver.remove();
    }

    public WebDriver pickDriver(String browserName) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridUrl = "http://10.0.0.102:4444";
        switch (browserName) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return new EdgeDriver(edgeOptions);
            case "grid-chrome":
                capabilities.setCapability("browser", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), capabilities);
            case "cloud":
                return getLambdaDriver();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(options);
        }
    }


    public String newNameGenerator() {
        String newname = UUID.randomUUID().toString();
        return newname;
    }

    public void doubleClick(String locator) {
        Actions dClick = new Actions(getDriver());
        WebElement dClickElement = getDriver().findElement(By.xpath(locator));
        dClick.doubleClick(dClickElement).perform();

    }

    public String getSuccessMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='success show']")));
        return notification.getText();

    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }
    public WebDriver getLambdaDriver () throws MalformedURLException {
        String userName = "igor.pavliuk";
        String authKey = "gcHjMzOxMR88LvKDJOIBwdQhgg6103wfCBDOsaMobzhDBt4M4V";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "124.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", userName);
        ltOptions.put("accessKey", authKey);
        ltOptions.put("video", true);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("project", "Koel");
        capabilities.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(URI.create("https://" + userName + ":" + authKey + hub).toURL(),capabilities);
    }
}

