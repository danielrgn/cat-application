package com.br.itau.cat.collector.application.unity.service;

import com.br.itau.cat.collector.application.enums.CatCategoryEnum;
import com.br.itau.cat.collector.application.factory.BreedFactory;
import com.br.itau.cat.collector.application.factory.BreedResponseDtoFactory;
import com.br.itau.cat.collector.application.mapper.BreedMapper;
import com.br.itau.cat.collector.application.service.BreedService;
import com.br.itau.cat.collector.application.service.CatService;
import com.br.itau.cat.collector.application.service.CollectCatInfoService;
import com.br.itau.cat.collector.application.service.api.CatBreedApiService;
import com.br.itau.cat.collector.application.service.impl.BreedServiceImpl;
import com.br.itau.cat.collector.application.unity.UnityAbstractTest;
import com.br.itau.cat.core.application.entity.Breed;
import com.br.itau.cat.core.application.repository.BreedRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class BreedServiceImplTest extends UnityAbstractTest {

    @InjectMocks
    private BreedServiceImpl breedService;

    @Mock
    private CatBreedApiService catBreedApiService;

    @Mock
    private BreedRepository breedRepository;

    @Mock
    private BreedMapper breedMapper;

    @Test
    void shouldCollectBreeds() {
        when(catBreedApiService.getAllBreeds()).thenReturn(List.of(BreedResponseDtoFactory.build(), BreedResponseDtoFactory.build()));
        when(breedMapper.fromBreedResponseDtoList(anyList())).thenReturn(List.of(BreedFactory.build(), BreedFactory.build()));
        when(breedRepository.saveAll(anyList())).thenReturn(List.of(BreedFactory.build(), BreedFactory.build()));

        final List<Breed> breeds = breedService.collectBreeds();

        assertThat(breeds).isNotEmpty();
    }

}