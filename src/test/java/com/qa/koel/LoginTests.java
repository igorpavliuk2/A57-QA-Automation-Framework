package com.qa.koel;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        getDriver().get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        getDriver().quit();
    }
}
//test hw15