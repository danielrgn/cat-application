package com.br.itau.catapplication.mapper;

import com.br.itau.catapplication.entity.Breed;
import com.br.itau.catapplication.feign.dto.BreedResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BreedMapper {

    List<Breed> fromBreedResponseDtoList(final List<BreedResponseDto> breedResponseDtoList);

    Breed breedResponseDtoToBreed(final BreedResponseDto breedResponseDto);
}
