package com.portfolio.covidMapApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CovidDataResponse {
    @JsonProperty("Global")
    private CovidGlobalData global;
    @JsonProperty("Countries")
    private List<CovidCountryData> countryDataList;

    public CovidDataResponse() {

    }

    public CovidDataResponse(CovidGlobalData global, List<CovidCountryData> countryDataList) {
        this.global = global;
        this.countryDataList = countryDataList;
    }

    public CovidGlobalData getGlobal() {
        return global;
    }

    public void setGlobal(CovidGlobalData global) {
        this.global = global;
    }

    public List<CovidCountryData> getCountryDataList() {
        return countryDataList;
    }

    public void setCountryDataList(List<CovidCountryData> countryDataList) {
        this.countryDataList = countryDataList;
    }

    @Override
    public String toString() {
        return "CovidDataResponse{" +
                "global=" + global +
                ", countryDataList=" + countryDataList +
                '}';
    }
}
