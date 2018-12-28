package com.expedia.dto;

public class SearchResultsDto {
    private String flightPrice;
    private String airlineName;
    private String departureTime;

    public void setFlightPrice(String flightPrice) {
        this.flightPrice = flightPrice;
    }

    public String getFlightPrice() {
        return flightPrice;
    }

    public void setAirline(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public SearchResultsDto withFlightPrice(String flightPrice) {
        this.flightPrice = flightPrice;
        return this;
    }

    public SearchResultsDto withAirline(String airlineName) {
        this.airlineName = airlineName;

        return this;
    }

    public SearchResultsDto withDepartureTime(String departureTime) {
        this.departureTime = departureTime;

        return this;
    }
}