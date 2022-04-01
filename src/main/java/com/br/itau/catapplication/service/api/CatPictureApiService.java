package com.br.itau.catapplication.service.api;

import com.br.itau.catapplication.entity.Breed;
import com.br.itau.catapplication.entity.Picture;
import com.br.itau.catapplication.feign.dto.CatPictureResponseDto;

import java.util.List;

public interface CatPictureApiService {

    List<CatPictureResponseDto> getPicturesByBreedId(String breedId);

    List<CatPictureResponseDto> getPicturesByCategoryId(Long categoryId);
}
