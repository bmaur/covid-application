package com.portfolio.covidMapApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class CovidCountryData{

    @JsonProperty("Country")
    private String countryName;
    @JsonProperty("CountryCode")
    private String countryCode;
    @JsonProperty("Slug")
    private String slug;
    @JsonProperty("NewConfirmed")
    private Integer newConfirmed;
    @JsonProperty("TotalConfirmed")
    private Integer totalConfirmed;
    @JsonProperty("NewDeaths")
    private Integer newDeaths;
    @JsonProperty("TotalDeaths")
    private Integer totalDeaths;
    @JsonProperty("NewRecovered")
    private Integer newRecovered;
    @JsonProperty("TotalRecovered")
    private Integer totalRecovered;
    @JsonProperty("Date")
    private LocalDateTime date;

    public CovidCountryData() {
    }

    public CovidCountryData(String countryName, String countryCode, String slug, Integer newConfirmed, Integer totalConfirmed,
                            Integer newDeaths, Integer totalDeaths, Integer newRecovered, Integer totalRecovered, LocalDateTime date) {
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.slug = slug;
        this.newConfirmed = newConfirmed;
        this.totalConfirmed = totalConfirmed;
        this.newDeaths = newDeaths;
        this.totalDeaths = totalDeaths;
        this.newRecovered = newRecovered;
        this.totalRecovered = totalRecovered;
        this.date = date;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getSlug() {
        return slug;
    }

    public Integer getNewConfirmed() {
        return newConfirmed;
    }

    public Integer getTotalConfirmed() {
        return totalConfirmed;
    }

    public Integer getNewDeaths() {
        return newDeaths;
    }

    public Integer getTotalDeaths() {
        return totalDeaths;
    }

    public Integer getNewRecovered() {
        return newRecovered;
    }

    public Integer getTotalRecovered() {
        return totalRecovered;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "CovidCountryData{" +
                "countryName='" + countryName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", slug='" + slug + '\'' +
                ", newConfirmed=" + newConfirmed +
                ", totalConfirmed=" + totalConfirmed +
                ", newDeaths=" + newDeaths +
                ", totalDeaths=" + totalDeaths +
                ", newRecovered=" + newRecovered +
                ", totalRecovered=" + totalRecovered +
                ", date=" + date +
                '}';
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setNewConfirmed(Integer newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public void setTotalConfirmed(Integer totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public void setNewDeaths(Integer newDeaths) {
        this.newDeaths = newDeaths;
    }

    public void setTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public void setNewRecovered(Integer newRecovered) {
        this.newRecovered = newRecovered;
    }

    public void setTotalRecovered(Integer totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
