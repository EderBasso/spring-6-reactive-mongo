package com.fantasmagorica.spring6reactivemongo.repository;

import com.fantasmagorica.spring6reactivemongo.domain.Movies;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movies, String> {
}
