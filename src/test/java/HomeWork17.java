import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import java.time.Duration;
import org.testng.annotations.Test;
@Test(description = "Test adding song to the playlist")
public class HomeWork17 extends BaseTest{
    public void addSongToPlaylist(){
        openUrl();
        login();
        //createPlaylist();
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.click();
        searchField.sendKeys("Pluto");
        searchField.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement viewAllButton = driver.findElement(By.cssSelector("h1>button[data-test]"));
        viewAllButton.click();
        WebElement searchedSong = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr/td[2]"));
        searchedSong.click();
        WebElement addToButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToButton.click();
        WebElement playlistName = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[5]"));
        playlistName.click();
        WebElement songAdded = driver.findElement(By.cssSelector("div[class='success show']"));
        Assert.assertEquals(songAdded.isDisplayed(),songAdded.isDisplayed());

        
    }
}
