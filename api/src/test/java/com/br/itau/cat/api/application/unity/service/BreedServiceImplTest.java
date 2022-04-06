package com.br.itau.cat.api.application.unity.service;

import com.br.itau.cat.api.application.exception.BreedNotFoundException;
import com.br.itau.cat.api.application.factory.BreedFactory;
import com.br.itau.cat.api.application.factory.BreedResponseDtoFactory;
import com.br.itau.cat.api.application.mapper.BreedMapper;
import com.br.itau.cat.api.application.service.impl.BreedServiceImpl;
import com.br.itau.cat.api.application.unity.UnityAbstractTest;
import com.br.itau.cat.api.application.v1.dto.BreedResponseDto;
import com.br.itau.cat.core.application.repository.BreedRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

class BreedServiceImplTest extends UnityAbstractTest {

    @InjectMocks
    private BreedServiceImpl breedService;

    @Mock
    private BreedRepository breedRepository;

    @Mock
    private BreedMapper breedMapper;

    @Test
    void testGetAllBreedResponseDtoSuccessfully() {
        when(breedRepository.findAll()).thenReturn(List.of(BreedFactory.build(), BreedFactory.build()));
        when(breedMapper.fromBreedList(anyList())).thenReturn(List.of(BreedResponseDtoFactory.build(), BreedResponseDtoFactory.build()));

        final List<BreedResponseDto> breedResponseDtoList = breedService.getAll();

        assertThat(breedResponseDtoList).isNotEmpty();
    }

    @Test
    void shouldThrowExceptionWhenTryToGetAll() {
        when(breedRepository.findAll()).thenReturn(Collections.emptyList());

        Assertions.assertThrows(BreedNotFoundException.class, () -> breedService.getAll());
    }

    @Test
    void testGetByIdBreedResponseDtoSuccessfully() {
        when(breedRepository.findById(any())).thenReturn(Optional.of(BreedFactory.build()));
        when(breedMapper.breedToBreedResponseDto(any())).thenReturn(BreedResponseDtoFactory.build());

        final BreedResponseDto breedResponseDto = breedService.getById(any());

        assertThat(breedResponseDto).isNotNull();
    }

    @Test
    void shouldThrowExceptionWhenTryToGetById() {
        when(breedRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(BreedNotFoundException.class, () -> breedService.getById(any()));
    }

    @Test
    void testGetByTemperamentBreedResponseDtoSuccessfully() {
        when(breedRepository.findByTemperamentContaining(any())).thenReturn(List.of(BreedFactory.build(), BreedFactory.build()));
        when(breedMapper.fromBreedList(anyList())).thenReturn(List.of(BreedResponseDtoFactory.build(), BreedResponseDtoFactory.build()));

        final List<BreedResponseDto> breedResponseDtoList = breedService.getByTemperament(any());

        assertThat(breedResponseDtoList).isNotEmpty();
    }

    @Test
    void shouldThrowExceptionWhenTryToGetByTemperament() {
        when(breedRepository.findByTemperamentContaining(any())).thenReturn(Collections.emptyList());

        Assertions.assertThrows(BreedNotFoundException.class, () -> breedService.getByTemperament(any()));
    }

    @Test
    void testGetByOriginBreedResponseDtoSuccessfully() {
        when(breedRepository.findByOriginContaining(any())).thenReturn(List.of(BreedFactory.build(), BreedFactory.build()));
        when(breedMapper.fromBreedList(anyList())).thenReturn(List.of(BreedResponseDtoFactory.build(), BreedResponseDtoFactory.build()));

        final List<BreedResponseDto> breedResponseDtoList = breedService.getByOrigin(any());

        assertThat(breedResponseDtoList).isNotEmpty();
    }

    @Test
    void shouldThrowExceptionWhenTryToGetByOrigin() {
        when(breedRepository.findByOriginContaining(any())).thenReturn(Collections.emptyList());

        Assertions.assertThrows(BreedNotFoundException.class, () -> breedService.getByOrigin(any()));
    }

}