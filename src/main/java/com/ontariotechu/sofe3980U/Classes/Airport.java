package com.ontariotechu.sofe3980U.Classes;

public class Airport {
    private String airportName;
    private String airportAbbreviation;
    private String airportCountry;

    public Airport(String airportName, String airportAbbreviation, String airportCountry) {
        this.airportName = airportName;
        this.airportAbbreviation = airportAbbreviation;
        this.airportCountry = airportCountry;
    }

    public String getAirportName() { return airportName; }
    public void setAirportName(String airportName) { this.airportName = airportName; }
    public String getAirportAbbreviation() { return airportAbbreviation; }
    public void setAirportAbbreviation(String airportAbbreviation) { this.airportAbbreviation = airportAbbreviation; }
    public String getAirportCountry() { return airportCountry; }
    public void setAirportCountry(String airportCountry) { this.airportCountry = airportCountry; }
}

