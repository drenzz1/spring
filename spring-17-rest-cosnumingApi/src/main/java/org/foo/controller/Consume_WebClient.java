package org.foo.controller;

import org.foo.entity.MovieCinema;
import org.foo.repository.GenreRepository;
import org.foo.repository.MovieCinemaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Consume_WebClient {

    private final MovieCinemaRepository movieCinemaRepository;

    public Consume_WebClient(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
    }

    @GetMapping("/flux-movie-cinemas")
    public Flux<MovieCinema> readAllCinema(){
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }

    @GetMapping("mono-movie-cinema/{id}")
    public Mono<MovieCinema> readById(@PathVariable("id")Long id){
        return Mono.just(movieCinemaRepository.findById(id).get());
    }

}
