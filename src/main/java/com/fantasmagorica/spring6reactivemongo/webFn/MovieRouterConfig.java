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
public class MovieRouterConfig {
    public static final String MOVIE_PATH = "/api/v3/movie";
    public static final String MOVIE_PATH_SLASH = "/api/v3/movie/";
    public static final String MOVIE_PATH_ID = "/api/v3/movie/{movieId}";
    public static final String MOVIE_PATH_ID_SLASH = "/api/v3/movie/{movieId}/";

    private final MovieHandler movieHandler;

    @Bean
    public RouterFunction<ServerResponse> movieRoutes(){
        return route()
                .GET(MOVIE_PATH, accept(MediaType.APPLICATION_JSON), movieHandler::listMovies)
                .GET(MOVIE_PATH_SLASH, accept(MediaType.APPLICATION_JSON), movieHandler::listMovies)
                .build();
    }
}
