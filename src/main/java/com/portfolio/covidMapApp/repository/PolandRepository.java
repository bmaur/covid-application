package com.portfolio.covidMapApp.repository;

import com.portfolio.covidMapApp.entity.CovidPolandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PolandRepository extends JpaRepository<CovidPolandEntity, Integer> {
    Optional<CovidPolandEntity> findByJptName(String jptName);
}
