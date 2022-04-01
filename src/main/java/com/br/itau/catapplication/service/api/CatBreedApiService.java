package com.br.itau.catapplication.service.api;

import com.br.itau.catapplication.feign.dto.BreedResponseDto;

import java.util.List;

public interface CatBreedApiService {

    List<BreedResponseDto> getAllBreeds();
}
