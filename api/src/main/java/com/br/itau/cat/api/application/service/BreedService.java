package com.br.itau.cat.api.application.service;

import com.br.itau.cat.api.application.v1.dto.BreedResponseDto;

import java.util.List;

public interface BreedService {

    List<BreedResponseDto> getAll();

    BreedResponseDto getById(String id);

    List<BreedResponseDto> getByTemperament(String temperament);

    List<BreedResponseDto> getByOrigin(String origin);
}
