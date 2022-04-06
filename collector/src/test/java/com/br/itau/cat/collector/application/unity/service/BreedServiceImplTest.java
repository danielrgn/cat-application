package com.br.itau.cat.collector.application.unity.service;

import com.br.itau.cat.collector.application.mapper.BreedMapper;
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
import static org.mockito.Mockito.anyList;
import static org.mockito.Mockito.when;

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
        when(catBreedApiService.getAllBreeds()).thenReturn(getBreedResponseDtoList());
        when(breedMapper.fromBreedResponseDtoList(anyList())).thenReturn(getBreedList());
        when(breedRepository.saveAll(anyList())).thenReturn(getBreedList());

        final List<Breed> breeds = breedService.collectBreeds();

        assertThat(breeds).isNotEmpty();
    }
}