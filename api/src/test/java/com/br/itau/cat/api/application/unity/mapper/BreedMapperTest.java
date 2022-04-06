package com.br.itau.cat.api.application.unity.mapper;

import com.br.itau.cat.api.application.factory.BreedFactory;
import com.br.itau.cat.api.application.mapper.BreedMapper;
import com.br.itau.cat.api.application.unity.MapperUnityTest;
import com.br.itau.cat.api.application.v1.dto.BreedResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

class BreedMapperTest extends MapperUnityTest {

    @Autowired
    private BreedMapper breedMapper;

    @Test
    void shouldMapBreedResponseListDtoToBreedList() {
        final var expected = BreedFactory.build();

        final List<BreedResponseDto> breedResponseDtoList = breedMapper.fromBreedList(Arrays.asList(BreedFactory.build(), BreedFactory.build()));

        breedResponseDtoList.forEach(breed ->
                Assertions.assertThat(breed).usingRecursiveComparison().isEqualTo(expected));
    }

    @Test
    void testMapWhenParamBreedResponseDtoListIsNull() {
        final List<BreedResponseDto> breedResponseDtoList = breedMapper.fromBreedList(null);

        Assertions.assertThat(breedResponseDtoList).isNull();
    }

    @Test
    void testMapWhenParamBreedResponseDtoIsNull() {
        final BreedResponseDto breedResponseDto = breedMapper.breedToBreedResponseDto(null);

        Assertions.assertThat(breedResponseDto).isNull();
    }

}