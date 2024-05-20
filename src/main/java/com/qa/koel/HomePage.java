package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(css = "i[data-testid='play-next-btn']")
    WebElement playNextSongButton;
    @FindBy(css = "span.play")
    WebElement playButton;
    @FindBy(css = "span[data-testid='pause-btn']")
    WebElement pauseButton;
    @FindBy(css = "div.plyr__progress")
    WebElement progressBar;
    @FindBy (css = "li[class='playlist playlist']")
    WebElement playlist;
    @FindBy (css = "a[href=\"/#!/profile\"]" )
    WebElement profileIcon;

   // static final By PLAY_NEXT_SONG_BUTTON = By.cssSelector("i[data-testid='play-next-btn']");
   // static final By PLAY_BUTTON = By.cssSelector("span.play");
   //static final By PAUSE_BUTTON = By.cssSelector("span[data-testid='pause-btn']");
   //static final By PROGRESS_BAR= By.cssSelector("div.plyr__progress");
   // static final By PLAYLIST = By.cssSelector("li[class='playlist playlist']");

    public HomePage (WebDriver driver) {
        super(driver);
    }
    public WebElement getPlayNextSongButton(){
        return playNextSongButton;
    }
    public WebElement getPlayButton (){

        return playButton;
    }
    public WebElement getPlayerProgressBar() {
        return progressBar;
    }
    public WebElement getPauseButton() {

        return pauseButton;
    }
    public WebElement getPlaylist () {

        return playlist;
    }



}
