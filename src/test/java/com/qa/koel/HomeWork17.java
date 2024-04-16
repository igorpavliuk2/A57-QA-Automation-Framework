package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.time.Duration;
import org.testng.annotations.Test;
@Test(description = "Test adding song to the playlist")
public class HomeWork17 extends BaseTest{
    public void addSongToPlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterLogin(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        WebElement searchField = getDriver().findElement(By.cssSelector("input[type='search']"));
        searchField.click();
        searchField.sendKeys("Pluto");
        searchField.sendKeys(Keys.ENTER);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement viewAllButton = getDriver().findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[1]/h1/button"));
        viewAllButton.click();
        WebElement searchedSong = getDriver().findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr/td[2]"));
        searchedSong.click();
        WebElement addToButton = getDriver().findElement(By.cssSelector("button[class='btn-add-to']"));
        addToButton.click();
        WebElement playlistName = getDriver().findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[5]"));
        playlistName.click();
        WebElement songAdded = getDriver().findElement(By.cssSelector("div[class='success show']"));
        Assert.assertEquals(songAdded.isDisplayed(),songAdded.isDisplayed());

        
    }
}
