package com.fantasmagorica.spring6reactivemongo.mapper;

import com.fantasmagorica.spring6reactivemongo.domain.Movies;
import com.fantasmagorica.spring6reactivemongo.model.MovieDTO;
import org.mapstruct.Mapper;

@Mapper
public interface MovieMapper {

    MovieDTO movieToMovieDto(Movies movies);

    Movies movieDtoToMovie(MovieDTO movieDTO);
}
