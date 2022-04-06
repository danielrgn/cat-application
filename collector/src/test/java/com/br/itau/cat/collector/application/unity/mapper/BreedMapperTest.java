package com.br.itau.cat.collector.application.unity.mapper;

import com.br.itau.cat.collector.application.factory.BreedFactory;
import com.br.itau.cat.collector.application.factory.BreedResponseDtoFactory;
import com.br.itau.cat.collector.application.mapper.BreedMapper;
import com.br.itau.cat.collector.application.unity.MapperUnityTest;
import com.br.itau.cat.core.application.entity.Breed;
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

        final List<Breed> breeds = breedMapper.fromBreedResponseDtoList(Arrays.asList(BreedResponseDtoFactory.build(), BreedResponseDtoFactory.build()));

        breeds.forEach(breed -> Assertions.assertThat(breed).usingRecursiveComparison().isEqualTo(expected));
    }

    @Test
    void testMapWhenParamBreedResponseDtoListIsNull() {
        final List<Breed> breeds = breedMapper.fromBreedResponseDtoList(null);

        Assertions.assertThat(breeds).isNull();
    }

    @Test
    void testMapWhenParamBreedResponseDtoIsNull() {
        final Breed breed = breedMapper.breedResponseDtoToBreed(null);

        Assertions.assertThat(breed).isNull();
    }

}