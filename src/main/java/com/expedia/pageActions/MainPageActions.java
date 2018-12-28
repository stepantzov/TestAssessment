package com.expedia.pageActions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.expedia.pages.MainPage;

import org.openqa.selenium.chrome.ChromeDriver;

public class MainPageActions extends MainPage {
    private static WebDriver driver;

    public MainPageActions(WebDriver driver) {
        this.driver = driver;
    }

    public static void clickFlightsTab() {
        elementClick(flightsTab());
    }

    public static void typeDepartureCity(String city) {
        flyingFromCityField().click();
        sendKeys(flyingFromCityField(), city);
    }

    public static void typeDestinationCity(String city) {
        flyingFromCityField().click();
        sendKeys(flyingToCityField(), city);
    }

    public static void selectAirportOnPopUp(String airportIndex) {
        elementClick(flyingToAirportPopUp(airportIndex));
    }

    public static void typeDepartingDate(String dateFormatted) {
        sendKeys(departingDateField(), dateFormatted);
    }

    public static void typeReturningDate(String dateFormatted) {
        //compatibility issue and differences in chrome/firefox driver behaviour solved below
        if (driverInstance instanceof ChromeDriver) {
            sendKeys(returningDateField(), Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            sendKeys(returningDateField(), dateFormatted);
        } else {
            for (int i = 0; i < 3; i++) {
                sendKeys(returningDateField(), Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            }
            sendKeys(returningDateField(), dateFormatted);
        }
    }

    public static void addOneAdultTraveler() {
        elementClick(travelersCountButton());
        elementClick(addOneAdultButton());
    }

    public static void searchForFlight() {
        elementClick(searchButton());
    }
}