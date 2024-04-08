package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork20 extends BaseTest{
    @Test(description="Delete playlist test with Waits")

    public void deletePlaylistWaits(){
        LoginPage loginPage = new LoginPage(getDriver());
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

