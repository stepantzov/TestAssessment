package com.expedia.pageActions;

import com.expedia.dto.SearchResultsDto;
import com.expedia.pages.SearchResultsPage;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class SearchResultsPageActions extends SearchResultsPage {
    private static WebDriver driver;
    static ArrayList flightDetailsRow = new ArrayList();

    public SearchResultsPageActions(WebDriver driver) {
        this.driver = driver;
    }

    public static String getFlightPriceFromSpecificRow(int designatedRow) {
        return getText(priceForSpecificRow(designatedRow));
    }

    public static String getFlightDepartureFromSpecificRow(int designatedRow) {
        return getText(departureForSpecificRow(designatedRow));
    }

    public static String getAirlineNameFromSpecificRow(int designatedRow) {
        return getText(airlineForSpecificRow(designatedRow));
    }

    public static SearchResultsDto getFlightDetailsForSpecificRow(int row) {
        return new SearchResultsDto()
                .withFlightPrice(getFlightPriceFromSpecificRow(row))
                .withAirline(getAirlineNameFromSpecificRow(row))
                .withDepartureTime(getFlightDepartureFromSpecificRow(row));
    }

    private static ArrayList<SearchResultsDto> getFlightDetailsNumberOfRows(int numberOfRows) {
        if (SearchResultsPage.ifPriceForSpecificRowPresent(numberOfRows)) {
            for (int i = 1; i <= numberOfRows; i++) {
                flightDetailsRow.add(getFlightDetailsForSpecificRow(i));
            }
        } else if (numberOfRows > 1) {
            System.out.println("Currently number of available flight rows are limited by search conditions.");
            System.out.println("Decreasing number of rows in results into " + --numberOfRows);
            getFlightDetailsNumberOfRows(numberOfRows);
        }

        return flightDetailsRow;
    }

    public static void printFlightDetailsForNumberOfRows(int numberOfRows) {
        int rowIndex = 1;
        ArrayList<SearchResultsDto> flightDetailsRows = getFlightDetailsNumberOfRows(numberOfRows);
        System.out.println("\nPlease find the search results and flight details on the rows below.");
        for (SearchResultsDto flightDetailsRow : flightDetailsRows) {
            System.out.format("Flight row number %d details: \n", (rowIndex++));
            System.out.println("Flight price: " + flightDetailsRow.getFlightPrice());
            System.out.println("Flight departure time: " + flightDetailsRow.getDepartureTime());
            System.out.println("Airline name: " + flightDetailsRow.getAirlineName());
            System.out.println();
        }
    }

    public static boolean verifyIfAirlinesIncludedPanelVisible() {
        return airlinesIncludedPanelList().isDisplayed();
    }
}