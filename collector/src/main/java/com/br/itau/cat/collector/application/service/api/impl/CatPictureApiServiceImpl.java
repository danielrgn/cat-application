package com.br.itau.cat.collector.application.service.api.impl;

import com.br.itau.cat.collector.application.feign.CatApiFeignClient;
import com.br.itau.cat.collector.application.feign.dto.CatPictureResponseDto;
import com.br.itau.cat.collector.application.service.api.CatPictureApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatPictureApiServiceImpl implements CatPictureApiService {

    private CatApiFeignClient catApiFeignClient;

    @Autowired
    public CatPictureApiServiceImpl(@Lazy CatApiFeignClient catApiFeignClient) {
        this.catApiFeignClient = catApiFeignClient;
    }

    @Override
    public List<CatPictureResponseDto> getPicturesByBreedId(final String breedId) {
        return catApiFeignClient.getImagesByBreedIds(breedId);
    }

    @Override
    public List<CatPictureResponseDto> getPicturesByCategoryId(final Long categoryId) {
        return catApiFeignClient.getImagesByCategoryIds(categoryId);
    }

}
