package org.foo.repository;

import org.foo.enums.State;
import org.foo.enums.Type;
import org.foo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    Movie findMovieByName(String name);

    //Write a derived query to list all movies between a range of prices

    List<Movie> findAllByPriceBetween(BigDecimal nr1,BigDecimal nr2);

    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findAllByDurationIsIn(List<Integer> duration);

    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> findAllByLocalDateAfter(LocalDate localDate);

    //Write a derived query to list all movies with a specific state and type
    List<Movie> findAllByStateAndType(State state, Type type);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("Select m from Movie m where  m.price > ?1 and m.price<?2")
    List<Movie>listAllMoviesBetween(Integer startingPrice,Integer endingPrice);

    //Write a JPQL query that returns all movie names
    @Query("select m.name from Movie m ")
    List<String> listAllMovieNames();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(nativeQuery = true , value = " Select * from movie where name = ?1")
    Movie listMovieByName(String name);

    //Write a native query that return the list of movies in a specific range of prices
    @Query(nativeQuery = true , value = "SELECT * from movie where price>?1 and price < ?2")
    List<Movie>listAllMoviesInASpecificRange(BigDecimal price1,BigDecimal price2);

    //Write a native query to return all movies where duration exists in the range of duration
    @Query(nativeQuery = true , value = "SELECT * from movie where movie.duration>?1 and movie.duration < ?2")
    List<Movie>listAllMoviesInASpecificRangeDurations(Integer duration1,Integer duration2);

    //Write a native query to list the top 5 most expensive movies
    @Query(nativeQuery = true,value = "SELECT * FROM movie order by price desc limit 5")
    List<Movie> listTop5MostExpensiveMovies();
}
