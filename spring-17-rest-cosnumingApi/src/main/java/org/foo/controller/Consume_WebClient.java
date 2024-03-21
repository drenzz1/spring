package org.foo.controller;

import org.foo.model.Genre;
import org.foo.repository.GenreRepository;
import org.foo.repository.MovieCinemaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consume_WebClient {

    private final MovieCinemaRepository movieCinemaRepository;
    private final GenreRepository genreRepository;

    public Consume_WebClient(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }


}
