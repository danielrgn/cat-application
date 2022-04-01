package com.br.itau.cat.collector.application.service.api;

import com.br.itau.cat.collector.application.feign.dto.BreedResponseDto;

import java.util.List;

public interface CatBreedApiService {

    List<BreedResponseDto> getAllBreeds();
}
