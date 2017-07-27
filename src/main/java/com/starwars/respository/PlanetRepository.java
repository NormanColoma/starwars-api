package com.starwars.respository;
import com.starwars.model.Planet;
import com.starwars.model.PlanetOnlyNameAndPopulation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(excerptProjection = PlanetOnlyNameAndPopulation.class)
@PreAuthorize("hasRole('ADMIN')")
public interface PlanetRepository extends JpaRepository<Planet, Long>{
    Page<Planet> findAll(Pageable page);
    Planet findByName(String name);
    List<Planet> findByNameContaining(String name);
    List<Planet> findAllByOrderByNameDesc();
    List<Planet> findByPopulationGreaterThan(Long population);
    List<Planet> findByPopulationBetween(Long min, Long max);
    List<Planet> findTop10ByOrderByPopulationAsc ();
    List<Planet> findTop10ByOrderByPopulationDesc ();
}
