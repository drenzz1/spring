package org.foo.repository;

import org.foo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Long> {
    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Optional<Cinema> findByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findTop3BySponsoredNameContainsOrderBySponsoredName(String sponsoredName);

    //Write a derived query to list all cinemas in a specific country
    List<Cinema> findAllByLocation_Country(String country);

    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findAllByNameOrSponsoredName(String name,String sponsoredName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("SELECT c.name from Cinema c where c.id = ?1")
    String getCinemaName(Long id);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(nativeQuery = true,value = "SELECT * from cinema c  join location l on l.id = c.location_id where l.country = ?1")
    List<Cinema> listAllCinemasByCountry(String country);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query (nativeQuery = true, value = "SELECT * from cinema where name ilike concat('%',?1,'%') or sponsored_name ilike concat('%',?1,'%')")
    List<Cinema>listAllCinemasByNameOrSponsoredNameContainsPattern(String pattern);

    //Write a native query to sort all cinemas by name
    @Query(nativeQuery = true,value = "SELECT * from cinema order by name")
    List<Cinema>listAllCinemasOrderByName();

    //Write a native query to distinct all cinemas by sponsored name
    @Query(nativeQuery = true,value = "SELECT DISTINCT sponsored_name from cinema")
    List<String>listAllDistinctSponsoredName();


}
