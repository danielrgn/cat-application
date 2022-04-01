package com.br.itau.cat.collector.application.service.api.impl;

import com.br.itau.cat.collector.application.feign.CatApiFeignClient;
import com.br.itau.cat.collector.application.feign.dto.BreedResponseDto;
import com.br.itau.cat.collector.application.service.api.CatBreedApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatBreedApiServiceImpl implements CatBreedApiService {

    @Autowired
    private CatApiFeignClient catApiFeignClient;

    @Override
    public List<BreedResponseDto> getAllBreeds() {
        return catApiFeignClient.getAllBreeds();
    }

}
