package com.expedia.searchTest;

import com.expedia.pageActions.MainPageActions;
import com.expedia.testConditions.TestConditions;
import org.testng.annotations.Test;

public class FlightSearchTest extends TestConditions {
    @Test
    public void flightSearchTest() {
        MainPageActions.clickFlightsTab();
    }
}