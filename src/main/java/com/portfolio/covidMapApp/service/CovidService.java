package com.portfolio.covidMapApp.service;

import com.portfolio.covidMapApp.entity.CovidCountryEntity;
import com.portfolio.covidMapApp.model.*;
import com.portfolio.covidMapApp.repository.CovidRepository;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CovidService {
    private final CovidRepository covidRepository;

    public CovidService(CovidRepository covidRepository) {
        this.covidRepository = covidRepository;
    }

    public void fillCovidData() throws IOException {

        final String uri = "https://api.covid19api.com/summary";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CovidDataResponse> result = restTemplate.exchange(uri, HttpMethod.GET, null, CovidDataResponse.class);
        System.out.println(result.getBody());

        List<CovidCountryData> data = result.getBody().getCountryDataList();

        data.forEach(covCountry -> {
            CovidCountryEntity covidCountryEntity = covidRepository.findByCountryName(covCountry.getCountryName())
                    .orElse(new CovidCountryEntity());
            covidCountryEntity.setCountryName(covCountry.getCountryName());
            covidCountryEntity.setCountryCode(covCountry.getCountryCode());
            covidCountryEntity.setSlug(covCountry.getSlug());
            covidCountryEntity.setNewConfirmed(covCountry.getNewConfirmed());
            covidCountryEntity.setTotalConfirmed(covCountry.getTotalConfirmed());
            covidCountryEntity.setNewDeaths(covCountry.getNewDeaths());
            covidCountryEntity.setTotalDeaths(covCountry.getTotalDeaths());
            covidCountryEntity.setNewRecovered(covCountry.getNewRecovered());
            covidCountryEntity.setTotalRecovered(covCountry.getTotalRecovered());
            covidCountryEntity.setDate(covCountry.getDate());
            covidRepository.save(covidCountryEntity);
        });
    }

    public List<CovidCountryEntity> getAllCountryData() {
        return covidRepository.findAll();
    }

    public List<CovidTotalDeaths> getAllCountryDeaths() {
        List<CovidCountryEntity> data = covidRepository.findAll();
        return data.stream()
                .map(this::mapToCovidTotalDeaths)
                .collect(Collectors.toList());
    }

    private CovidTotalDeaths mapToCovidTotalDeaths(CovidCountryEntity countryEntity) {
        CovidTotalDeaths covidTotalDeaths = new CovidTotalDeaths();
        covidTotalDeaths.setCountryName(countryEntity.getCountryName());
        covidTotalDeaths.setTotalDeaths(countryEntity.getTotalDeaths());
        return covidTotalDeaths;
    }


    public CovidGlobalDeathsAndCountries getGlobalDeathsAndCountries() {
        List<CovidCountryEntity> data = covidRepository.findAll();
        return new CovidGlobalDeathsAndCountries(
                data.stream()
                        .mapToInt(CovidCountryEntity::getTotalDeaths)
                        .reduce(0, Integer::sum),
                data.stream()
                        .map(this::mapToCovidTotalDeaths)
                        .collect(Collectors.toList())
        );
    }

    public CovidGlobalRecovered getGlobalRecovered() {
        List<CovidCountryEntity> data = covidRepository.findAll();
        return new CovidGlobalRecovered(
                data.stream()
                        .mapToInt(CovidCountryEntity::getTotalRecovered)
                        .reduce(0, Integer::sum),
                data.stream()
                        .map(this::mapToCovidTotalRecovered).
                        collect(Collectors.toList())
        );

    }

    private CovidTotalRecovered mapToCovidTotalRecovered(CovidCountryEntity countryEntity) {
        CovidTotalRecovered covidTotalRecovered = new CovidTotalRecovered();
        covidTotalRecovered.setCountryName(countryEntity.getCountryName());
        covidTotalRecovered.setTotalRecovered(countryEntity.getTotalDeaths());
        return covidTotalRecovered;
    }

}