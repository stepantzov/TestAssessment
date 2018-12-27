package com.expedia.pages;

import com.expedia.coreFunctions.ActionsSetup;
import org.openqa.selenium.WebElement;

public class MainPage extends ActionsSetup {
    protected static WebElement flightsTab() {
        return getElement("//button[@id='tab-flight-tab-hp']", DELAY, XPATH);
    }

    protected static WebElement flyingFromCityField() {
        return getElement("//*[@id='flight-origin-hp-flight']", DELAY, XPATH);
    }

    protected static WebElement flyingToCityField() {
        return getElement("//*[@id='flight-destination-hp-flight']", DELAY, XPATH);
    }

    protected static WebElement flyingToAirportPopUp(String airport) {
        return getElement("//*[contains(text(), '" + airport + "')]", DELAY, XPATH);
    }

    protected static WebElement departingDateField() {
        return getElement("//*[@id='flight-departing-hp-flight']", DELAY, XPATH);
    }

    protected static WebElement returningDateField() {
        return getElement("//*[@id='flight-returning-hp-flight']", DELAY, XPATH);
    }

    protected static WebElement travelersCountButton() {
        return getElement("//*[@id='traveler-selector-hp-flight']" +
                "/div[@class='menu-bar gcw-travel-selector-wrapper']", DELAY, XPATH);
    }

    protected static WebElement addOneAdultButton() {
        return getElement("//*[@id='traveler-selector-hp-flight']" +
                "//div[@class='traveler-selector-sinlge-room-data traveler-selector-room-data']/div[1]/div[4]", DELAY, XPATH);
    }

    protected static WebElement searchButton() {
        return getElement("//*[@id='gcw-flights-form-hp-flight']/div[7]//button[@type='submit']", DELAY, XPATH);
    }
}