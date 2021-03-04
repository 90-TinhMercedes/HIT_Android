package com.example.day06ver01;

public class Country {
    private String Country_Region;
    private String Confirmed;
    private String Deaths;
    private String Recovered;

    public Country() {
    }

    public Country(String country_Region, String confirmed, String deaths, String recovered) {
        Country_Region = country_Region;
        Confirmed = confirmed;
        Deaths = deaths;
        Recovered = recovered;
    }

    @Override
    public String toString() {
        return "Country{" +
                "Country_Region='" + Country_Region + '\'' +
                ", Confirmed='" + Confirmed + '\'' +
                ", Deaths='" + Deaths + '\'' +
                ", Recovered='" + Recovered + '\'' +
                '}';
    }

    public String getCountry_Region() {
        return Country_Region;
    }

    public void setCountry_Region(String country_Region) {
        Country_Region = country_Region;
    }

    public String getConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(String confirmed) {
        Confirmed = confirmed;
    }

    public String getDeaths() {
        return Deaths;
    }

    public void setDeaths(String deaths) {
        Deaths = deaths;
    }

    public String getRecovered() {
        return Recovered;
    }

    public void setRecovered(String recovered) {
        Recovered = recovered;
    }
}
