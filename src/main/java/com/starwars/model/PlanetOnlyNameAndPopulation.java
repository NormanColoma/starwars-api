package com.starwars.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Planet.class)
public interface PlanetOnlyNameAndPopulation {
    String getName();
    Long getPopulation();
}
