package com.qa.koel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver pageDriver;
    public WebDriverWait wait;

    public BasePage (WebDriver pageDriver) { //not null
       wait = new WebDriverWait(pageDriver, Duration.ofSeconds(5));
        this.pageDriver = pageDriver;
        PageFactory.initElements(pageDriver,this);

    }
    public WebElement findElementsUsingByLocator (WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
