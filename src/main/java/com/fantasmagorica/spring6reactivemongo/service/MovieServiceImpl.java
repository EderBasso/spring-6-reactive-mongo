package com.fantasmagorica.spring6reactivemongo.service;

import com.fantasmagorica.spring6reactivemongo.mapper.MovieMapper;
import com.fantasmagorica.spring6reactivemongo.model.MovieDTO;
import com.fantasmagorica.spring6reactivemongo.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;

    @Override
    public Mono<MovieDTO> saveMovie(Mono<MovieDTO> movieDTO) {
        return movieDTO.map(movieMapper::movieDtoToMovie)
                .flatMap(movieRepository::save)
                .map(movieMapper::movieToMovieDto);
    }

    @Override
    public Mono<MovieDTO> getById(String id) {
        return null;
    }

    @Override
    public Flux<MovieDTO> listMovies() {
        return movieRepository.findAll().map(movieMapper::movieToMovieDto);
    }
}
