package com.fantasmagorica.spring6reactivemongo.repository;

import com.fantasmagorica.spring6reactivemongo.domain.Beer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BeerRepository extends ReactiveMongoRepository<Beer, String> {
}
