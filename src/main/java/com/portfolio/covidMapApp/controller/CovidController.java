package com.portfolio.covidMapApp.controller;

import com.portfolio.covidMapApp.entity.CovidCountryEntity;
import com.portfolio.covidMapApp.model.CovidGlobalDeathsAndCountries;
import com.portfolio.covidMapApp.model.CovidGlobalRecovered;
import com.portfolio.covidMapApp.model.CovidTotalDeaths;
import com.portfolio.covidMapApp.service.CovidService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CovidController {
    private final CovidService covidService;

    public CovidController(CovidService covidService) {
        this.covidService = covidService;
    }

    @PostMapping("/fillCovidData")
    void addCovidCountryData() throws IOException {
        covidService.fillCovidData();
    }

    @GetMapping("/getCovidData")
    List<CovidCountryEntity> getAllCovidCountryData() {
        return covidService.getAllCountryData();
    }

    @GetMapping("/covid/confirmed")
    List<CovidTotalDeaths> getConfirmedCovidDeaths() {
        return covidService.getAllCountryDeaths();
    }

    @GetMapping("/covid/deaths")
    CovidGlobalDeathsAndCountries getGlobalDeaths() {
        return covidService.getGlobalDeathsAndCountries();
    }

    @GetMapping("covid/recovered")
    CovidGlobalRecovered getGlobalRecovered() {
        return covidService.getGlobalRecovered();
    }

}