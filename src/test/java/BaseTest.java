import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    public WebDriver driver = null;
    public WebDriverWait wait = null;
    public String url = "https://qa.koel.app/";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @Parameters({"BaseURL"})
    @BeforeMethod
    public void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(BaseURL);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public void login(){
        WebElement loginField = driver.findElement(By.cssSelector("input[type='email']"));
        loginField.sendKeys("igor.pavliuk@testpro.io");
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("1q2w3e4R");
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }
    public String newNameGenerator(){
        String newName = UUID.randomUUID().toString();
        return newName;
    }
    public void createPlaylist() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement createPlaylistButton = driver.findElement(By.cssSelector("h1>i[role='button']"));
        createPlaylistButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]")));
        WebElement newPlaylistElement = driver.findElement(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]"));
        newPlaylistElement.click();
        WebElement playlistNameEmptyField = driver.findElement(By.cssSelector("form>input[name='name']"));
        playlistNameEmptyField.click();
        playlistNameEmptyField.sendKeys(newNameGenerator());
        playlistNameEmptyField.sendKeys(Keys.ENTER);

    }
    public void doubleClick(String locator){
        Actions dClick = new Actions(driver);
        WebElement dClickElement = driver.findElement(By.xpath(locator));
        dClick.doubleClick(dClickElement).perform();

    }
    public String getSuccessMessage(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='success show']")));
        return notification.getText();

    }
}