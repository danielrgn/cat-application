package com.br.itau.catapplication.service.api.impl;

import com.br.itau.catapplication.feign.CatApiFeignClient;
import com.br.itau.catapplication.feign.dto.CatPictureResponseDto;
import com.br.itau.catapplication.service.api.CatPictureApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatPictureApiServiceImpl implements CatPictureApiService {

    @Autowired
    private CatApiFeignClient catApiFeignClient;

    @Override
    public List<CatPictureResponseDto> getPicturesByBreedId(final String breedId) {
        return catApiFeignClient.getImagesByBreedIds(breedId);
    }

    @Override
    public List<CatPictureResponseDto> getPicturesByCategoryId(final Long categoryId) {
        return catApiFeignClient.getImagesByCategoryIds(categoryId);
    }

}
