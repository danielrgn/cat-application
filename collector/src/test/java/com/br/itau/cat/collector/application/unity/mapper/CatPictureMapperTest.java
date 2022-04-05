package com.br.itau.cat.collector.application.unity.mapper;

import com.br.itau.cat.collector.application.factory.BreedFactory;
import com.br.itau.cat.collector.application.factory.BreedResponseDtoFactory;
import com.br.itau.cat.collector.application.factory.CatPictureResponseDtoFactory;
import com.br.itau.cat.collector.application.factory.PictureFactory;
import com.br.itau.cat.collector.application.mapper.BreedMapper;
import com.br.itau.cat.collector.application.mapper.CatPictureMapper;
import com.br.itau.cat.collector.application.unity.MapperUnityTest;
import com.br.itau.cat.core.application.entity.Breed;
import com.br.itau.cat.core.application.entity.Picture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

class CatPictureMapperTest extends MapperUnityTest {

    @Autowired
    private CatPictureMapper catPictureMapper;

    @Test
    void shouldMapCatPictureResponseListDtoToPictureList() {
        final var expected = PictureFactory.build();

        final List<Picture> pictures = catPictureMapper.fromCatPictureResponseDtoList(
                Arrays.asList(CatPictureResponseDtoFactory.build(), CatPictureResponseDtoFactory.build()));

        pictures.forEach(picture -> Assertions.assertThat(picture).usingRecursiveComparison().isEqualTo(expected));
    }

    @Test
    void testMapWhenParamCatPictureResponseDtoListIsNull() {
        final List<Picture> pictures = catPictureMapper.fromCatPictureResponseDtoList(null);

        Assertions.assertThat(pictures).isNull();
    }

    @Test
    void testMapWhenParamBreedResponseDtoIsNull() {
        final Picture picture = catPictureMapper.catPictureResponseDtoToPicture(null);

        Assertions.assertThat(picture).isNull();
    }

}