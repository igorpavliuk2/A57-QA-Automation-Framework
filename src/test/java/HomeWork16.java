import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Test(description = "Test registration button")
public class HomeWork16 extends BaseTest {

    public void  registrationNavigation() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        WebElement registrationButton = driver.findElement(By.cssSelector("div>a[href='registration']"));
        registrationButton.click();
        WebElement registrationForm = driver.findElement((By.cssSelector("form[method='POST']")));
        Assert.assertTrue(registrationForm.isDisplayed());
        driver.quit();
    }

}
