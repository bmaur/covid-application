package com.portfolio.covidMapApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.covidMapApp.entity.CovidCountryEntity;
import com.portfolio.covidMapApp.entity.CovidPolandEntity;
import com.portfolio.covidMapApp.model.*;
import com.portfolio.covidMapApp.model.poland.PolandCovidData;
import com.portfolio.covidMapApp.model.poland.PolandCovidDetails;
import com.portfolio.covidMapApp.model.poland.PolandCovidResponse;
import com.portfolio.covidMapApp.repository.CovidRepository;
import com.portfolio.covidMapApp.repository.PolandRepository;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CovidService {
    private final CovidRepository covidRepository;
    private final PolandRepository polandRepository;
    private final ObjectMapper objectMapper;

    public CovidService(CovidRepository covidRepository, ObjectMapper objectMapper, PolandRepository polandRepository) {
        this.covidRepository = covidRepository;
        this.objectMapper = objectMapper;
        this.polandRepository = polandRepository;
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

    public void fillPolandCovidData() {
        final String uri = "https://services1.arcgis.com/YmCK8KfESHdxUQgm/arcgis/rest/services/wojewodztwa_corona_widok/FeatureServer/0/query?f=json&where=1=1&returnGeometry=false&spatialRel=esriSpatialRelIntersects&outFields=*&resultOffset=0&resultRecordCount=4000&resultType=standard&cacheHint=true";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String result = restTemplate.getForObject(uri, String.class);
        PolandCovidResponse polandCovidResponse = null;
        try {
            polandCovidResponse = objectMapper.readValue(result, PolandCovidResponse.class);
            System.out.println(polandCovidResponse.toString());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        polandCovidResponse.getFeatures().forEach(covPoland -> {
            CovidPolandEntity covidPolandEntity = polandRepository.findByJptName(covPoland.getPolandCovidData().getJptName())
                    .orElse(new CovidPolandEntity());
            covidPolandEntity.setObjectId(covPoland.getPolandCovidData().getObjectID());
            covidPolandEntity.setJptName(covPoland.getPolandCovidData().getJptName());
            covidPolandEntity.setPointCount(covPoland.getPolandCovidData().getPointCount());
            covidPolandEntity.setSumConfirmed(covPoland.getPolandCovidData().getSumConfirmed());
            covidPolandEntity.setSumDeaths(covPoland.getPolandCovidData().getSumDeaths());
            covidPolandEntity.setSumRecovered(covPoland.getPolandCovidData().getSumRecovered());
            covidPolandEntity.setShapeArea(covPoland.getPolandCovidData().getShapeArea());
            covidPolandEntity.setShapeLength(covPoland.getPolandCovidData().getShapeLength());
            covidPolandEntity.setNameFilter(covPoland.getPolandCovidData().getNameFilter());
            polandRepository.save(covidPolandEntity);
        });
    }

    public PolandCovidDetails getDetails() {
        List<CovidPolandEntity> data = polandRepository.findAll();
        return new PolandCovidDetails(
                data.stream()
                        .mapToInt(CovidPolandEntity::getSumConfirmed)
                        .reduce(0, Integer::sum),
                data.stream()
                        .mapToInt(CovidPolandEntity::getSumDeaths)
                        .reduce(0, Integer::sum),
                data.stream()
                        .mapToInt(CovidPolandEntity::getSumRecovered)
                        .reduce(0, Integer::sum),
                data.stream()
                        .map(this::mapToPolandCovidData)
                        .collect(Collectors.toList())
        );
    }

    private PolandCovidData mapToPolandCovidData(CovidPolandEntity covidPolandEntity) {
        PolandCovidData polandCovidData = new PolandCovidData();
        polandCovidData.setObjectID(covidPolandEntity.getObjectId());
        polandCovidData.setJptName(covidPolandEntity.getJptName());
        polandCovidData.setPointCount(covidPolandEntity.getPointCount());
        polandCovidData.setSumConfirmed(covidPolandEntity.getSumConfirmed());
        polandCovidData.setSumDeaths(covidPolandEntity.getSumDeaths());
        polandCovidData.setSumRecovered(covidPolandEntity.getSumRecovered());
        polandCovidData.setShapeArea(covidPolandEntity.getShapeArea());
        polandCovidData.setShapeLength(covidPolandEntity.getShapeLength());
        polandCovidData.setNameFilter(covidPolandEntity.getNameFilter());
        return polandCovidData;
    }
}