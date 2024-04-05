package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaylistsPage extends BasePage{
    static final By DELETE_PLAYLIST_BUTTON = By.cssSelector("button[title='Delete this playlist']");
    static final By OK_BUTTON = By.cssSelector("button[class='ok']");
    static final By SUCCESS_NOTIFICATION = By.xpath("//div[contains(text(),'Deleted playlist')]");
    public PlaylistsPage(WebDriver driver) {
        super(driver);
    }
    public WebElement getDeletePlaylistButton () {
        return pageDriver.findElement(DELETE_PLAYLIST_BUTTON);
    }
    public WebElement getOkButton (){
        return pageDriver.findElement(OK_BUTTON);
    }
    public WebElement getSuccessNotification () {
        return pageDriver.findElement(SUCCESS_NOTIFICATION);
    }
}
