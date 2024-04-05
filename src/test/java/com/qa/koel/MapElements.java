package com.qa.koel;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test(description = "Demo")
public class MapElements extends BaseTest{
    public void countSongInPlaylist() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterLogin(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        choosePlaylistByName("123");
        displayAllSongs();
        System.out.println(getPlaylistDetails());
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }



}

