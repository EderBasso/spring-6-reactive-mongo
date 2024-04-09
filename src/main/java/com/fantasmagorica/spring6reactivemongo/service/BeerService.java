package com.fantasmagorica.spring6reactivemongo.service;

import com.fantasmagorica.spring6reactivemongo.model.BeerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BeerService {

    Mono<BeerDTO> saveBeer(Mono<BeerDTO> beerDTO);

    Mono<BeerDTO> getById(String id);

    Flux<BeerDTO> listBeers();

    Mono<BeerDTO> updateBeer(String beerId, BeerDTO beerDTO);

    Mono<Void> deleteBeerById(String beerId);

    Flux<BeerDTO> listBeersByStyle(String style);
}
