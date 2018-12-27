package com.expedia.searchTest;

import com.expedia.pageActions.MainPageActions;
import com.expedia.pageActions.SearchResultsPageActions;
import com.expedia.testConditions.TestConditions;
import com.expedia.utils.TimeStamp;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FlightSearchTest extends TestConditions {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void flightSearchTest() {
        MainPageActions.clickFlightsTab();
        MainPageActions.typeDepartureCity("London");
        MainPageActions.selectAirportOnPopUp("LHR");

        MainPageActions.typeDestinationCity("Dublin");
        MainPageActions.selectAirportOnPopUp("DUB");

        MainPageActions.typeDepartingDate(TimeStamp.getDateFormatted(5));
        MainPageActions.typeReturningDate(TimeStamp.getDateFormatted(8));

        MainPageActions.addOneAdultTraveler();
        MainPageActions.pressSearchButton();

        softAssert.assertEquals(SearchResultsPageActions.getFlightPriceFromSpecificRow(1), "$234");
        softAssert.assertNotEquals(SearchResultsPageActions.getFlightPriceFromSpecificRow(1), "€0.92");
        softAssert.assertTrue(SearchResultsPageActions.verifyIfAirlinesIncludedPanelVisible(), "Airlines Included panel is not visible.");
        SearchResultsPageActions.printFlightDetailsForNumberOfRows(3);

        softAssert.assertAll();
    }
}