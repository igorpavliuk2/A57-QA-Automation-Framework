package com.qa.koel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver pageDriver;

    public BasePage (WebDriver driver) { //not null
        this.pageDriver = driver;
        PageFactory.initElements(pageDriver,this);
    }
}
