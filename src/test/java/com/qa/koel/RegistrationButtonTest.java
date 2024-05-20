package com.qa.koel;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test(description = "Test registration button")
public class RegistrationButtonTest extends BaseTest {
    LoginPage loginPage;
    public void  registrationNavigation() {
    loginPage = new LoginPage(getDriver());
//      Added ChromeOptions argument below to fix websocket error
        loginPage.getRegistrationButton().click();
        loginPage.getRegistrationForm();
        Assert.assertTrue(loginPage.getRegistrationForm().isDisplayed());
    }

}
