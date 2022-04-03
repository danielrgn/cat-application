package com.br.itau.cat.api.application.mapper;

import com.br.itau.cat.api.application.v1.dto.BreedResponseDto;
import com.br.itau.cat.core.application.entity.Breed;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BreedMapper {

    List<BreedResponseDto> fromBreedList(final List<Breed> breeds);

    BreedResponseDto breedToBreedResponseDto(final  Breed breed);
}
