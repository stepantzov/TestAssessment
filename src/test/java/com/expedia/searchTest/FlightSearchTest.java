package com.expedia.searchTest;

import com.expedia.pageActions.MainPageActions;
import com.expedia.pageActions.SearchResultsPageActions;
import com.expedia.testConditions.TestConditions;
import com.expedia.utils.TimeStamp;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FlightSearchTest extends TestConditions {
    private SoftAssert softAssert = new SoftAssert();

    @Test
    @Parameters({"departureCity", "departureAirport", "destinationCity",
            "destinationAirport", "positiveFlightPrice", "negativeFlightPrice"})
    public void flightSearchTest(String departureCity, String departureAirport, String destinationCity,
                                 String destinationAirport, String positiveFlightPrice, String negativeFlightPrice) {
        MainPageActions.clickFlightsTab();
        MainPageActions.typeDepartureCity(departureCity);
        MainPageActions.selectAirportOnPopUp(departureAirport);

        MainPageActions.typeDestinationCity(destinationCity);
        MainPageActions.selectAirportOnPopUp(destinationAirport);

        MainPageActions.typeDepartingDate(TimeStamp.getDateFormatted(5));
        MainPageActions.typeReturningDate(TimeStamp.getDateFormatted(8));

        MainPageActions.addOneAdultTraveler();
        MainPageActions.searchForFlight();

        softAssert.assertTrue(SearchResultsPageActions.
                verifyIfAirlinesIncludedPanelVisible(), "Airlines Included panel is not visible.");
        softAssert.assertEquals(SearchResultsPageActions.
                getFlightPriceFromSpecificRow(1), positiveFlightPrice);
        softAssert.assertNotEquals(SearchResultsPageActions.
                getFlightPriceFromSpecificRow(1), negativeFlightPrice);

        SearchResultsPageActions.printFlightDetailsForNumberOfRows(3);

        softAssert.assertAll();
    }
}