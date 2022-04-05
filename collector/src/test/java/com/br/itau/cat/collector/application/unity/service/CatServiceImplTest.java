package com.br.itau.cat.collector.application.unity.service;

import com.br.itau.cat.collector.application.enums.CatCategoryEnum;
import com.br.itau.cat.collector.application.factory.BreedFactory;
import com.br.itau.cat.collector.application.factory.BreedResponseDtoFactory;
import com.br.itau.cat.collector.application.factory.CatPictureResponseDtoFactory;
import com.br.itau.cat.collector.application.factory.PictureFactory;
import com.br.itau.cat.collector.application.feign.dto.CatPictureResponseDto;
import com.br.itau.cat.collector.application.mapper.CatPictureMapper;
import com.br.itau.cat.collector.application.service.api.CatPictureApiService;
import com.br.itau.cat.collector.application.service.impl.BreedServiceImpl;
import com.br.itau.cat.collector.application.service.impl.CatServiceImpl;
import com.br.itau.cat.collector.application.unity.UnityAbstractTest;
import com.br.itau.cat.core.application.entity.Breed;
import com.br.itau.cat.core.application.entity.Cat;
import com.br.itau.cat.core.application.repository.CatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class CatServiceImplTest extends UnityAbstractTest {

    @InjectMocks
    private CatServiceImpl catService;

    @Mock
    private CatPictureApiService catPictureApiService;

    @Mock
    private CatRepository catRepository;

    @Mock
    private CatPictureMapper catPictureMapper;

    @Test
    void testSaveCatsAndPictureByBreed() {
        when(catPictureApiService.getPicturesByBreedId(any())).thenReturn(List.of(CatPictureResponseDtoFactory.build(), CatPictureResponseDtoFactory.build()));
        when(catPictureMapper.fromCatPictureResponseDtoList(anyList())).thenReturn(List.of(PictureFactory.build(), PictureFactory.build()));

        catService.saveCatsAndPictures(Breed.builder().build());

        verify(catRepository, times(1)).save(any(Cat.class));
    }

    @ParameterizedTest(name= "testSaveCatsAndPictureByCatCategoryEnum=({0})")
    @EnumSource(CatCategoryEnum.class)
    void testSaveCatsAndPictureByCatCategoryEnum(final CatCategoryEnum catCategoryEnum) {
        when(catPictureApiService.getPicturesByCategoryId(any())).thenReturn(List.of(CatPictureResponseDtoFactory.build(), CatPictureResponseDtoFactory.build()));

        catService.saveCatsAndPictures(catCategoryEnum);

        verify(catRepository, times(2)).save(any(Cat.class));
    }

}