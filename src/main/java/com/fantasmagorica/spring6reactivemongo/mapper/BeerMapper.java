package com.fantasmagorica.spring6reactivemongo.mapper;

import com.fantasmagorica.spring6reactivemongo.domain.Beer;
import com.fantasmagorica.spring6reactivemongo.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    BeerDTO beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDTO beerDTO);
}