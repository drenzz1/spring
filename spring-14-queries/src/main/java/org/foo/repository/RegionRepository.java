package org.foo.repository;

import org.foo.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository  extends JpaRepository<Region,Long> {
    List<Region> findByCountry(String country); // Select * from region where region is
    List<Region> findDistinctByCountry(String country);
    List<Region>findRegionsByCountryContains(String contains);
    List<Region>findRegionsByCountryContainsOrderByCountry(String country);
    Region findTopByCountry(String country);
}
