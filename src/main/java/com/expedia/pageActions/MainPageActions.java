package com.expedia.pageActions;

import org.openqa.selenium.WebDriver;
import com.expedia.pages.MainPage;

public class MainPageActions extends MainPage {
    protected static WebDriver driver;

    public MainPageActions(WebDriver driver) {
        this.driver = driver;
    }

    public static void clickFlightsTab() {
        elementClick(flightsTab());
    }
}