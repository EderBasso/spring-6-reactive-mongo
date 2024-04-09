package com.fantasmagorica.spring6reactivemongo.service;

import com.fantasmagorica.spring6reactivemongo.mapper.MovieMapper;
import com.fantasmagorica.spring6reactivemongo.model.MovieDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.awaitility.Awaitility.await;

@SpringBootTest
class MoviesServiceImplTest {

    @Autowired
    MovieService movieService;
    @Autowired
    MovieMapper movieMapper;

    @Test
    void testListMovies() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Flux<MovieDTO> movieFlux = movieService.listMovies();
        movieFlux.subscribe(movieDTO -> {
            System.out.println(movieDTO.getTitle());
            atomicBoolean.set(true);
        });

        await().untilTrue(atomicBoolean);
    }

    @Test
    void testSaveMovie() {
        MovieDTO movieDTO = MovieDTO.builder()
                .title("Title Test")
                .plot("Generic Test Plot")
                .runtime(12l)
                .build();

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Mono<MovieDTO> savedMono = movieService.saveMovie(Mono.just(movieDTO));

        savedMono.subscribe(savedDto -> {
            System.out.println(savedDto.getId());
            atomicBoolean.set(true);
        });

        await().untilTrue(atomicBoolean);
    }
}