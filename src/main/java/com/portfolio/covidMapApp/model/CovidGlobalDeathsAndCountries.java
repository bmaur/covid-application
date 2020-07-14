package com.portfolio.covidMapApp.model;

import java.util.List;

public class CovidGlobalDeathsAndCountries {

    private int globalDeaths;
    private List<CovidTotalDeaths> countryList;


    @Override
    public String toString() {
        return "CovidGlobalDeathsAndCountries{" +
                "globalDeaths=" + globalDeaths +
                ", countryList=" + countryList +
                '}';
    }

    public CovidGlobalDeathsAndCountries(Integer globalDeaths, List<CovidTotalDeaths> countryList) {
        this.globalDeaths = globalDeaths;
        this.countryList = countryList;
    }

    public int getGlobalDeaths() {
        return globalDeaths;
    }

    public void setGlobalDeaths(int globalDeaths) {
        this.globalDeaths = globalDeaths;
    }

    public List<CovidTotalDeaths> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<CovidTotalDeaths> countryList) {
        this.countryList = countryList;
    }
}
