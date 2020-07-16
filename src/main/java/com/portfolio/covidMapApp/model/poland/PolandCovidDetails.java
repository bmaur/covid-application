package com.portfolio.covidMapApp.model.poland;

import java.util.List;

public class PolandCovidDetails {

    private int polandSumConfirmed;
    private int polandSumDeaths;
    private int polandSumRecovered;
    private List<PolandCovidData> polandCovidDataList;

    public PolandCovidDetails(int polandSumConfirmed, int polandSumDeaths, int polandSumRecovered, List<PolandCovidData> polandCovidDataList) {
        this.polandSumConfirmed = polandSumConfirmed;
        this.polandSumDeaths = polandSumDeaths;
        this.polandSumRecovered = polandSumRecovered;
        this.polandCovidDataList = polandCovidDataList;
    }

    @Override
    public String toString() {
        return "PolandCovidDetails{" +
                "polandSumConfirmed=" + polandSumConfirmed +
                ", polandSumDeaths=" + polandSumDeaths +
                ", polandSumRecovered=" + polandSumRecovered +
                ", polandCovidDataList=" + polandCovidDataList +
                '}';
    }

    public int getPolandSumConfirmed() {
        return polandSumConfirmed;
    }

    public void setPolandSumConfirmed(int polandSumConfirmed) {
        this.polandSumConfirmed = polandSumConfirmed;
    }

    public int getPolandSumDeaths() {
        return polandSumDeaths;
    }

    public void setPolandSumDeaths(int polandSumDeaths) {
        this.polandSumDeaths = polandSumDeaths;
    }

    public int getPolandSumRecovered() {
        return polandSumRecovered;
    }

    public void setPolandSumRecovered(int polandSumRecovered) {
        this.polandSumRecovered = polandSumRecovered;
    }

    public List<PolandCovidData> getPolandCovidDataList() {
        return polandCovidDataList;
    }

    public void setPolandCovidDataList(List<PolandCovidData> polandCovidDataList) {
        this.polandCovidDataList = polandCovidDataList;
    }
}
