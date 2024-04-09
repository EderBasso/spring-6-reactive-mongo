package com.fantasmagorica.spring6reactivemongo.repository;

import com.fantasmagorica.spring6reactivemongo.domain.Beer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface BeerRepository extends ReactiveMongoRepository<Beer, String> {

    Flux<Beer> findByBeerStyle(String beerStyle);
}
