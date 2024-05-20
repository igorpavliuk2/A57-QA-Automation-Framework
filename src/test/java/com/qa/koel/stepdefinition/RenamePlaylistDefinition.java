package com.qa.koel.stepdefinition;

import com.qa.koel.BaseTest;
import com.qa.koel.LoginPage;
import com.qa.koel.PlaylistsPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RenamePlaylistDefinition extends BaseTest {
    protected String url = "https://qa.koel.app/";
    public String email = "igor.pavliuk@testpro.io";
    public String password = "1q2w3e4R";
    private WebDriver driver;

   @Given("I open Koel Website with valid credentials and located at Home Page")
   public void setupDriver() {
       WebDriverManager.chromedriver().setup();
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");
       driver = new ChromeDriver(options);
       getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// one time
       getDriver().manage().window().fullscreen();
       getDriver().get(url);
       LoginPage loginPage = new LoginPage(getDriver());
       loginPage.enterLogin(email);
       loginPage.enterPassword(password);
       loginPage.clickSubmitButton();
   }

    public WebDriver getDriver() {return this.driver;}
    @When("I double clicked for playlist name, delete previous playlist name, generate new and write")
    public void renamePlaylistBDD() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        doubleClick("//*[@id=\"playlists\"]/ul/li[3]/a");
        WebElement playlistNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistNameField.sendKeys(newNameGenerator());
        playlistNameField.sendKeys(Keys.ENTER);
    }


       @Then("Success notification is displayed")
               public void renamePlaylistSuccess() {
           PlaylistsPage playlistsPage = new PlaylistsPage(getDriver());
           Assert.assertTrue(playlistsPage.getSuccessNotification().isDisplayed());
       }
    @After
    public void closeDriver() {
        getDriver().quit();
    }
}





