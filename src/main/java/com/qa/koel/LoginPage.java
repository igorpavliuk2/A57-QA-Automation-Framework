package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    static final By PASSWORD_FIELD = By.cssSelector("input[type='password']");
    static final By EMAIL_FIELD = By.cssSelector("input[type='email']");
    static final By LOGIN_BUTTON = By.cssSelector("button[type='submit']");
    static final By REGISTRATION_BUTTON = By.cssSelector("div>a[href='registration']");
    static final By REGISTRATION_FORM = By.cssSelector("form[method='POST']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void enterLogin(String email){
        WebElement loginField = pageDriver.findElement(EMAIL_FIELD);
        loginField.click();
        loginField.sendKeys(email);
    }
    public void enterPassword(String password) {
        WebElement passwordField = pageDriver.findElement(PASSWORD_FIELD);
        passwordField.click();
        passwordField.sendKeys(password);
    }
    public void clickSubmitButton() {
        WebElement submitButton = pageDriver.findElement(LOGIN_BUTTON);
        submitButton.click();
    }
    public WebElement getRegistrationButton() {
        return pageDriver.findElement(REGISTRATION_BUTTON);
    }
    public WebElement getRegistrationForm() {
        return pageDriver.findElement(REGISTRATION_FORM);
    }
}
