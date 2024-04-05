package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork21 extends BaseTest {
    @Test(description = "Rename playlist test")
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterLogin(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        doubleClick("//*[@id=\"playlists\"]/ul/li[3]/a");
        WebElement playlistNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playlistNameField.sendKeys(newNameGenerator());
        playlistNameField.sendKeys(Keys.ENTER);
        getSuccessMessage();
        Assert.assertEquals(getSuccessMessage(),getSuccessMessage());

    }
}
