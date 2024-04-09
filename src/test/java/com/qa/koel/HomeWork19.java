package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork19 extends BaseTest{

    @Test(description="Delete playlist test")


    public void deletePlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(loginPage.pageDriver);
        loginPage.enterLogin(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();

        WebDriverWait wait = new WebDriverWait(loginPage.pageDriver, Duration.ofSeconds(10));
        PageFactory.initElements(loginPage.pageDriver,this);
        homepage.getPlaylist().click();
        PlaylistsPage playlistspage = new PlaylistsPage(getDriver());
        playlistspage.getDeletePlaylistButton().click();
        playlistspage.getOkButton().click();
        wait.until(ExpectedConditions.visibilityOf(playlistspage.successNotification));
        Assert.assertTrue(playlistspage.getSuccessNotification().isDisplayed());


    }
}
