package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    static final By PLAY_NEXT_SONG_BUTTON = By.cssSelector("i[data-testid='play-next-btn']");
    static final By PLAY_BUTTON = By.cssSelector("span.play");
    static final By PAUSE_BUTTON = By.cssSelector("span[data-testid='pause-btn']");
    static final By PROGRESS_BAR= By.cssSelector("div.plyr__progress");
    static final By PLAYLIST = By.cssSelector("li[class='playlist playlist']");

    public HomePage (WebDriver driver) {
        super(driver);
    }
    public WebElement getPlayNextSongButton(){
        return pageDriver.findElement(PLAY_NEXT_SONG_BUTTON);
    }
    public WebElement getPlayButton (){
        return pageDriver.findElement(PLAY_BUTTON);
    }
    public WebElement getPlayerProgressBar() {
        return pageDriver.findElement(PROGRESS_BAR);
    }
    public WebElement getPauseButton() {
        return pageDriver.findElement(PAUSE_BUTTON);
    }
    public WebElement getPlaylist () {
        return pageDriver.findElement(PLAYLIST);
    }



}
