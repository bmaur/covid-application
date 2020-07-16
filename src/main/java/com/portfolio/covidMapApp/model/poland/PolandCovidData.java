package com.portfolio.covidMapApp.model.poland;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolandCovidData {

    @JsonProperty("OBJECTID")
    private int objectID;
    @JsonProperty("jpt_nazwa_")
    private String jptName;
    @JsonProperty("Point_Count")
    private int pointCount;
    @JsonProperty("SUM_Confirmed")
    private int sumConfirmed;
    @JsonProperty("SUM_Deaths")
    private int sumDeaths;
    @JsonProperty("SUM_Recovered")
    private int sumRecovered;
    @JsonProperty("Shape__Area")
    private double shapeArea;
    @JsonProperty("Shape__Length")
    private double shapeLength;
    @JsonProperty("Nazwa_filter")
    private String nameFilter;

    public PolandCovidData() {
    }

    public PolandCovidData(int objectID, String jptName, int pointCount, int sumConfirmed, int sumDeaths, int sumRecovered, double shapeArea, double shapeLength, String nameFilter) {
        this.objectID = objectID;
        this.jptName = jptName;
        this.pointCount = pointCount;
        this.sumConfirmed = sumConfirmed;
        this.sumDeaths = sumDeaths;
        this.sumRecovered = sumRecovered;
        this.shapeArea = shapeArea;
        this.shapeLength = shapeLength;
        this.nameFilter = nameFilter;
    }

    @Override
    public String toString() {
        return "PolandCovidData{" +
                "objectID=" + objectID +
                ", jptName='" + jptName + '\'' +
                ", pointCount=" + pointCount +
                ", sumConfirmed=" + sumConfirmed +
                ", sumDeaths=" + sumDeaths +
                ", sumRecovered=" + sumRecovered +
                ", shapeArea=" + shapeArea +
                ", shapeLength=" + shapeLength +
                ", nameFilter='" + nameFilter + '\'' +
                '}';
    }

    public int getObjectID() {
        return objectID;
    }

    public String getJptName() {
        return jptName;
    }

    public int getPointCount() {
        return pointCount;
    }

    public int getSumConfirmed() {
        return sumConfirmed;
    }

    public int getSumDeaths() {
        return sumDeaths;
    }

    public int getSumRecovered() {
        return sumRecovered;
    }

    public double getShapeArea() {
        return shapeArea;
    }

    public double getShapeLength() {
        return shapeLength;
    }

    public String getNameFilter() {
        return nameFilter;
    }

    public void setObjectID(int objectID) {
        this.objectID = objectID;
    }

    public void setJptName(String jptName) {
        this.jptName = jptName;
    }

    public void setPointCount(int pointCount) {
        this.pointCount = pointCount;
    }

    public void setSumConfirmed(int sumConfirmed) {
        this.sumConfirmed = sumConfirmed;
    }

    public void setSumDeaths(int sumDeaths) {
        this.sumDeaths = sumDeaths;
    }

    public void setSumRecovered(int sumRecovered) {
        this.sumRecovered = sumRecovered;
    }

    public void setShapeArea(double shapeArea) {
        this.shapeArea = shapeArea;
    }

    public void setShapeLength(double shapeLength) {
        this.shapeLength = shapeLength;
    }

    public void setNameFilter(String nameFilter) {
        this.nameFilter = nameFilter;
    }
}
