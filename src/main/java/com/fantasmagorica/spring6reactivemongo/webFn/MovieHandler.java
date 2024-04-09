package com.fantasmagorica.spring6reactivemongo.webFn;

import com.fantasmagorica.spring6reactivemongo.model.MovieDTO;
import com.fantasmagorica.spring6reactivemongo.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class MovieHandler {

    private final MovieService movieService;
    private final Validator validator;

    public Mono<ServerResponse> listMovies(ServerRequest request) {
        return ServerResponse.ok()
                .body(movieService.listMovies(), MovieDTO.class);
    }
}
