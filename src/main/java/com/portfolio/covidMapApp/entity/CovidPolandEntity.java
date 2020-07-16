package com.portfolio.covidMapApp.entity;

import javax.persistence.*;

@Entity
@Table(name = "poland")
public class CovidPolandEntity  {

    @Id
    private Integer ObjectId;
    private String jptName;
    private int pointCount;
    private int sumConfirmed;
    private int sumDeaths;
    private int sumRecovered;
    private double shapeArea;
    private double shapeLength;
    private String nameFilter;

    @Override
    public String toString() {
        return "CovidPolandEntity{" +
                "ObjectId=" + ObjectId +
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

    public int getObjectId() {
        return ObjectId;
    }

    public void setObjectId(int objectId) {
        ObjectId = objectId;
    }

    public String getJptName() {
        return jptName;
    }

    public void setJptName(String jptName) {
        this.jptName = jptName;
    }

    public int getPointCount() {
        return pointCount;
    }

    public void setPointCount(int pointCount) {
        this.pointCount = pointCount;
    }

    public int getSumConfirmed() {
        return sumConfirmed;
    }

    public void setSumConfirmed(int sumConfirmed) {
        this.sumConfirmed = sumConfirmed;
    }

    public int getSumDeaths() {
        return sumDeaths;
    }

    public void setSumDeaths(int sumDeaths) {
        this.sumDeaths = sumDeaths;
    }

    public int getSumRecovered() {
        return sumRecovered;
    }

    public void setSumRecovered(int sumRecovered) {
        this.sumRecovered = sumRecovered;
    }

    public double getShapeArea() {
        return shapeArea;
    }

    public void setShapeArea(double shapeArea) {
        this.shapeArea = shapeArea;
    }

    public double getShapeLength() {
        return shapeLength;
    }

    public void setShapeLength(double shapeLength) {
        this.shapeLength = shapeLength;
    }

    public String getNameFilter() {
        return nameFilter;
    }

    public void setNameFilter(String nameFilter) {
        this.nameFilter = nameFilter;
    }
}
