package com.br.itau.cat.collector.application.unity.service;

import com.br.itau.cat.collector.application.enums.CatCategoryEnum;
import com.br.itau.cat.collector.application.factory.BreedFactory;
import com.br.itau.cat.collector.application.service.BreedService;
import com.br.itau.cat.collector.application.service.CatService;
import com.br.itau.cat.collector.application.service.CollectCatInfoService;
import com.br.itau.cat.collector.application.unity.UnityAbstractTest;
import com.br.itau.cat.core.application.entity.Breed;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CollectCatInfoServiceTest extends UnityAbstractTest {

    @InjectMocks
    private CollectCatInfoService collectCatInfoService;

    @Mock
    private BreedService breedService;

    @Mock
    private CatService catService;

    @Test
    void shouldExecuteCollectCatInfo() {
        when(breedService.collectBreeds()).thenReturn(List.of(BreedFactory.build(), BreedFactory.build()));

        collectCatInfoService.execute();

        verify(catService, times(2)).saveCatsAndPictures(any(Breed.class));
        verify(catService, times(1)).saveCatsAndPictures(CatCategoryEnum.HATS);
        verify(catService, times(1)).saveCatsAndPictures(CatCategoryEnum.SUNGLASSES);
    }

}