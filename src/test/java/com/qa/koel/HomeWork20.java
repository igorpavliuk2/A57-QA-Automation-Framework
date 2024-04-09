package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork20 extends BaseTest{
    @Test(description="Delete playlist test with Waits")

    public void deletePlaylistWaits(){
        LoginPage loginPage = new LoginPage(getDriver());
        WebDriverWait wait = new WebDriverWait(loginPage.pageDriver, Duration.ofSeconds(10));
        PageFactory.initElements(loginPage.pageDriver,this);
        loginPage.enterLogin(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        HomePage homepage = new HomePage(getDriver());
        homepage.getPlaylist().click();
        PlaylistsPage playlistspage = new PlaylistsPage(getDriver());
        playlistspage.getDeletePlaylistButton().click();
        playlistspage.getOkButton().click();
        wait.until(ExpectedConditions.visibilityOf(playlistspage.successNotification));
        Assert.assertTrue(playlistspage.getSuccessNotification().isDisplayed());


    }
}

