package com.portfolio.covidMapApp.model;

import java.util.List;

public class CovidGlobalRecovered {
    private Integer globalRecovered;
    private List<CovidTotalRecovered> countryList;

    public CovidGlobalRecovered(Integer globalRecovered, List<CovidTotalRecovered> countryList) {
        this.globalRecovered = globalRecovered;
        this.countryList = countryList;
    }

    public Integer getGlobalRecovered() {
        return globalRecovered;
    }

    public void setGlobalRecovered(Integer globalRecovered) {
        this.globalRecovered = globalRecovered;
    }

    public List<CovidTotalRecovered> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<CovidTotalRecovered> countryList) {
        this.countryList = countryList;
    }

    @Override
    public String toString() {
        return "CovidGlobalRecovered{" +
                "globalRecovered=" + globalRecovered +
                ", countryList=" + countryList +
                '}';
    }
}
