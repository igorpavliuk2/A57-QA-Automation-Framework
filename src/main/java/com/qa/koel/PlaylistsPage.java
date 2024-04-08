package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaylistsPage extends BasePage{
    @FindBy (css = "button[title='Delete this playlist']")
    WebElement deletePlaylistButton;
    //static final By DELETE_PLAYLIST_BUTTON = By.cssSelector("button[title='Delete this playlist']");
    @FindBy (css = "button[class='ok']")
    WebElement okButton;
    //static final By OK_BUTTON = By.cssSelector("button[class='ok']");
    @FindBy (css = "//div[contains(text(),'Deleted playlist')]")
    WebElement successNotification;
    //static final By SUCCESS_NOTIFICATION = By.xpath("//div[contains(text(),'Deleted playlist')]");
    public PlaylistsPage(WebDriver driver) {
        super(driver);
    }
    public WebElement getDeletePlaylistButton () {
        return deletePlaylistButton;
    }
    public WebElement getOkButton (){

        return okButton;
    }
    public WebElement getSuccessNotification () {
        return successNotification;
    }
}
