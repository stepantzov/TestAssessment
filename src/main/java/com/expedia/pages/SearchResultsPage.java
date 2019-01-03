package com.expedia.pages;

import com.expedia.coreFunctions.ActionsSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends ActionsSetup {
    protected static WebElement priceForSpecificRow(int designatedRow) {
        return getElement("//div[@id='flight-listing-container']" +
                "//li[" + designatedRow + "]//div[1]/span[@class='full-bold no-wrap']", DELAY, XPATH);
    }

    protected static Boolean priceForSpecificRowPresent(int designatedRow) {
        try {
            driverInstance.findElement(By.xpath("//div[@id='flight-listing-container']" +
                    "//li[" + designatedRow + "]//div[1]/span[@class='full-bold no-wrap']"));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    protected static WebElement departureForSpecificRow(int designatedRow) {
        return getElement("//div[@id='flight-listing-container']" +
                "//li[" + designatedRow + "]//span[@data-test-id='departure-time']", DELAY, XPATH);
    }

    protected static WebElement airlineForSpecificRow(int designatedRow) {
        return getElement("//div[@id='flight-listing-container']" +
                "//li[" + designatedRow + "]//span[@data-test-id='airline-name']", DELAY, XPATH);
    }

    protected static WebElement airlinesIncludedPanelList() {
        return getElement("//fieldset[@id='airlines']" +
                "//div[@class='uitk-grid all-grid-fallback-alt category-grid']", DELAY, XPATH);
    }
}