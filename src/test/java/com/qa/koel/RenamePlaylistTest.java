package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RenamePlaylistTest extends BaseTest {
    @Test(description = "Rename playlist test")
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistsPage playlistsPage = new PlaylistsPage(getDriver());
        WebDriverWait wait = new WebDriverWait(playlistsPage.pageDriver, Duration.ofSeconds(10));
        PageFactory.initElements(playlistsPage.pageDriver,this);
        loginPage.enterLogin(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        doubleClick("//*[@id=\"playlists\"]/ul/li[4]/a");
        WebElement playlistNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='inline-playlist-name-input']")));
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playlistNameField.sendKeys(newNameGenerator());
        playlistNameField.sendKeys(Keys.ENTER);
        Assert.assertTrue(playlistsPage.successNotification.isDisplayed());

    }
}
