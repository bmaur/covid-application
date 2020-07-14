package com.portfolio.covidMapApp.repository;

import com.portfolio.covidMapApp.entity.CovidCountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CovidRepository extends JpaRepository<CovidCountryEntity, Long> {
    Optional<CovidCountryEntity> findByCountryName(String countryName);
}
