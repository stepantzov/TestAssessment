package com.expedia.pages;

import com.expedia.coreFunctions.ActionsSetup;
import org.openqa.selenium.WebElement;

public class MainPage extends ActionsSetup {
    public static WebElement flightsTab() {
        return getElement("//button[@id='tab-flight-tab-hp']", DELAY, XPATH);
    }
}