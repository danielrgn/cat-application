package com.br.itau.cat.collector.application.service.api.impl;

import com.br.itau.cat.collector.application.feign.CatApiFeignClient;
import com.br.itau.cat.collector.application.feign.dto.BreedResponseDto;
import com.br.itau.cat.collector.application.service.api.CatBreedApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatBreedApiServiceImpl implements CatBreedApiService {

    private CatApiFeignClient catApiFeignClient;

    @Autowired
    public CatBreedApiServiceImpl(@Lazy CatApiFeignClient catApiFeignClient) {
        this.catApiFeignClient = catApiFeignClient;
    }

    @Override
    public List<BreedResponseDto> getAllBreeds() {
        return catApiFeignClient.getAllBreeds();
    }

}
