package com.fantasmagorica.spring6reactivemongo.webFn;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class BeerRouterConfig {
    public static final String BEER_PATH = "/api/v3/beer";
    public static final String BEER_PATH_SLASH = "/api/v3/beer/";
    public static final String BEER_PATH_ID = "/api/v3/beer/{beerId}";
    public static final String BEER_PATH_ID_SLASH = "/api/v3/beer/{beerId}/";

    private final BeerHandler beerHandler;

    @Bean
    public RouterFunction<ServerResponse> beerRoutes() {
        return route()
                .GET(BEER_PATH, accept(MediaType.APPLICATION_JSON), beerHandler::listBeers)
                .GET(BEER_PATH_SLASH, accept(MediaType.APPLICATION_JSON), beerHandler::listBeers)
                .GET(BEER_PATH_ID, accept(MediaType.APPLICATION_JSON), beerHandler::getBeerById)
                .GET(BEER_PATH_ID_SLASH, accept(MediaType.APPLICATION_JSON), beerHandler::getBeerById)
                .POST(BEER_PATH, accept(MediaType.APPLICATION_JSON), beerHandler::createBeer)
                .POST(BEER_PATH_SLASH, accept(MediaType.APPLICATION_JSON), beerHandler::createBeer)
                .PUT(BEER_PATH_ID, accept(MediaType.APPLICATION_JSON), beerHandler::updateBeer)
                .PUT(BEER_PATH_ID_SLASH, accept(MediaType.APPLICATION_JSON), beerHandler::updateBeer)
                .DELETE(BEER_PATH_ID, accept(MediaType.APPLICATION_JSON), beerHandler::deleteBeer)
                .DELETE(BEER_PATH_ID_SLASH, accept(MediaType.APPLICATION_JSON), beerHandler::deleteBeer)
                .GET(BEER_PATH, accept(MediaType.APPLICATION_JSON), beerHandler::getBeerById)
                .build();
    }
}
