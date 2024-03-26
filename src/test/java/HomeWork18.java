import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import java.time.Duration;
import org.testng.annotations.Test;
@Test(description="Play song test")
public class HomeWork18 extends BaseTest{
    public void playSong(){
        openUrl();
        login();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement playNextSongButton = driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        playNextSongButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement playSongButton = driver.findElement(By.cssSelector("span.play"));
        playSongButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement playerProgress = driver.findElement(By.cssSelector("div.plyr__progress"));
        WebElement pauseButton = driver.findElement(By.cssSelector("span[data-testid='pause-btn']"));
        Assert.assertTrue(playerProgress.isDisplayed()&pauseButton.isDisplayed());
    }
}
