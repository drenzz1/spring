package org.foo.repository;

import org.foo.model.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema,Long> {
    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    Optional<MovieCinema> findMovieCinemaById(Long id);

    //Write a derived query to count all movie cinemas with a specific cinema id
    Integer countAllByCinema_Id(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countAllByMovie_Id(Long id );

    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findAllByDateTimeAfter(LocalTime dateTime);

    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findTop3ByOrderByMovie_PriceDesc();
    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema>findAllByMovie_NameContains(String name);

    //Write a derived query to list all movie cinemas in a specific location name
    List<MovieCinema> findAllByCinema_Location_Name(String location);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("select mc from MovieCinema mc where mc.dateTime>?1")
    List<MovieCinema> listAllMovieCinemasWithHigherSpecificDate(LocalTime localTime);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(nativeQuery = true,value ="SELECT count(*) from movie_cinema where cinema_id=?1 ")
    Integer countMovieCinemasBYCinemaId(Long id);

    //Write a native query that returns all movie cinemas by location name
    @Query(value = "SELECT * FROM movie_cinema mc JOIN cinema c " +
            " ON mc.cinema_id = c.id JOIN location l ON c.location_id = l.id " +
            " WHERE l.name = ?1",nativeQuery = true)
    List<MovieCinema> listAllMovieCinemasByLocationName(String name);

}
