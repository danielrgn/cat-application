package com.br.itau.cat.collector.application.mapper;

import com.br.itau.cat.collector.application.feign.dto.BreedResponseDto;
import com.br.itau.cat.core.application.entity.Breed;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BreedMapper {

    List<Breed> fromBreedResponseDtoList(final List<BreedResponseDto> breedResponseDtoList);

    Breed breedResponseDtoToBreed(final BreedResponseDto breedResponseDto);
}
