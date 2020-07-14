package com.portfolio.covidMapApp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "country")
public class CovidCountryEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String countryName;
    private String countryCode;
    private String slug;
    private Integer newConfirmed;
    private Integer totalConfirmed;
    private Integer newDeaths;
    private Integer totalDeaths;
    private Integer newRecovered;
    private Integer totalRecovered;
    private LocalDateTime date;

    @Override
    public String toString() {
        return "CovidCountryEntity{" +
                ", countryName='" + countryName + '\'' +
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

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getNewConfirmed() {
        return newConfirmed;
    }

    public void setNewConfirmed(Integer newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public Integer getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(Integer totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public Integer getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(Integer newDeaths) {
        this.newDeaths = newDeaths;
    }

    public Integer getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Integer getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(Integer newRecovered) {
        this.newRecovered = newRecovered;
    }

    public Integer getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(Integer totalRecovered) {
        this.totalRecovered = totalRecovered;
    }
}
