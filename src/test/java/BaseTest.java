import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    public WebDriver driver = null;
    public String url = "https://qa.koel.app/";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    public void openUrl (){
        driver.get(url);
    }
    public void login(){
        WebElement loginField = driver.findElement(By.cssSelector("input[type='email']"));
        loginField.sendKeys("igor.pavliuk@testpro.io");
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("1q2w3e4R");
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }
    public void createPlaylist() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    WebElement createPlaylistButton = driver.findElement(By.cssSelector("h1>i[role='button']"));
    createPlaylistButton.click();
    WebElement newPlaylistElement = driver.findElement(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]"));
    newPlaylistElement.click();
    WebElement playlistNameEmptyField = driver.findElement(By.cssSelector("form>input[name='name']"));
    playlistNameEmptyField.click();
    String newName = UUID.randomUUID().toString();
    playlistNameEmptyField.sendKeys(newName);
    playlistNameEmptyField.sendKeys(Keys.ENTER);
    }
}