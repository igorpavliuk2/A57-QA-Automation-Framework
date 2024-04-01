import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

public class HomeWork20 extends BaseTest{
    @Test(description="Delete playlist test with Waits")

    public void deletePlaylistWaits(){
        login();
        WebElement playlist = driver.findElement(By.cssSelector("li[class='playlist playlist']"));
        playlist.click();
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        deletePlaylistButton.click();
        WebElement okButton = driver.findElement(By.cssSelector("button[class='ok']"));
        okButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Deleted playlist')]")));
        WebElement playlistDeletedNotification = driver.findElement(By.xpath("//div[contains(text(),'Deleted playlist')]"));
        Assert.assertTrue(playlistDeletedNotification.isDisplayed());


    }
}

