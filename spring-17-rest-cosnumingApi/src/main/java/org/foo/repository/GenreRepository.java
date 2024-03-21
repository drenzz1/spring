package org.foo.repository;

import org.foo.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that return all genres
    @Query("Select g from Genre  g ")
    List<Genre> listAllGenres();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns genres by containing name
    @Query(nativeQuery = true, value = "Select * from genre where name ilike concat('%',?1,'%')")
    List<Genre> listAllGenresByNameContains(String name);

}
