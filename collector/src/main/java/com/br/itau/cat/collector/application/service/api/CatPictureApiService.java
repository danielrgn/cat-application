package com.br.itau.cat.collector.application.service.api;

import com.br.itau.cat.collector.application.feign.dto.CatPictureResponseDto;

import java.util.List;

public interface CatPictureApiService {

    List<CatPictureResponseDto> getPicturesByBreedId(String breedId);

    List<CatPictureResponseDto> getPicturesByCategoryId(Long categoryId);
}
