package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Test(description = "Test registration button")
public class HomeWork16 extends BaseTest {
    LoginPage loginPage;
    public void  registrationNavigation() {
    loginPage = new LoginPage(getDriver());
//      Added ChromeOptions argument below to fix websocket error
        loginPage.getRegistrationButton().click();
        loginPage.getRegistrationForm();
        Assert.assertTrue(loginPage.getRegistrationForm().isDisplayed());
    }

}
