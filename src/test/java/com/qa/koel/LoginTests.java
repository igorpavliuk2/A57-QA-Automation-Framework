package com.qa.koel;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(loginPage.pageDriver);
        loginPage.enterLogin(wrongEmail);
        loginPage.enterPassword(wrongPassword);
        loginPage.clickSubmitButton();

        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }
    @Test
    public void loginCorrectEmailPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(loginPage.pageDriver);
        loginPage.enterLogin(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();

        Assert.assertTrue(homepage.profileIcon.isDisplayed());
    }
}