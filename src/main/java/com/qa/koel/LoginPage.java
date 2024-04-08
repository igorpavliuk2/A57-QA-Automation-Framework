package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "input[type='password']")
        WebElement passwordLocator;
    @FindBy(css = "input[type='email']")
    WebElement emailField;
    @FindBy(css = "button[type='submit']")
    WebElement loginButton;
    @FindBy(css = "div>a[href='registration']")
    WebElement registrationButton;
    @FindBy(css = "form[method='POST']")
    WebElement registrationForm;
    //static final By PASSWORD_FIELD = By.cssSelector("input[type='password']");
    //static final By EMAIL_FIELD = By.cssSelector("input[type='email']");
    //static final By LOGIN_BUTTON = By.cssSelector("button[type='submit']");
    //static final By REGISTRATION_BUTTON = By.cssSelector("div>a[href='registration']");
    //static final By REGISTRATION_FORM = By.cssSelector("form[method='POST']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void enterLogin(String email){
        emailField.click();
        emailField.sendKeys(email);
    }
    public void enterPassword(String password) {

        passwordLocator.click();
        passwordLocator.sendKeys(password);
    }
    public void clickSubmitButton() {
        loginButton.click();
    }
    public WebElement getRegistrationButton() {
        return registrationButton;
    }
    public WebElement getRegistrationForm() {
        return registrationForm;
    }
}
