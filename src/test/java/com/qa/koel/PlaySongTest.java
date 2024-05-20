package com.qa.koel;

import org.testng.Assert;
import java.time.Duration;
import org.testng.annotations.Test;
@Test(description="Play song test")
public class PlaySongTest extends BaseTest{
    HomePage homepage;
    public void playSong(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterLogin(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        HomePage homepage = new HomePage(getDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homepage.getPlayNextSongButton().click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homepage.getPlayButton().click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homepage.getPlayerProgressBar();
        homepage.getPauseButton();
        Assert.assertTrue(homepage.getPauseButton().isDisplayed()&homepage.getPlayerProgressBar().isDisplayed());
    }
}
