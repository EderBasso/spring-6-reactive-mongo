package com.fantasmagorica.spring6reactivemongo.service;


import com.fantasmagorica.spring6reactivemongo.mapper.BeerMapper;
import com.fantasmagorica.spring6reactivemongo.model.BeerDTO;
import com.fantasmagorica.spring6reactivemongo.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerMapper beerMapper;
    private final BeerRepository beerRepository;

    @Override
    public Mono<BeerDTO> saveBeer(Mono<BeerDTO> beerDTO) {
        return beerDTO.map(beerMapper::beerDtoToBeer)
                .flatMap(beerRepository::save)
                .map(beerMapper::beerToBeerDto);
    }

    @Override
    public Mono<BeerDTO> getById(String id) {
        return null;
    }
}
