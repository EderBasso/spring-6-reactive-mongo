package com.fantasmagorica.spring6reactivemongo.service;

import com.fantasmagorica.spring6reactivemongo.model.MovieDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    Mono<MovieDTO> saveMovie(Mono<MovieDTO> movieDTO);

    Mono<MovieDTO> getById(String id);

    Flux<MovieDTO> listMovies();
}
