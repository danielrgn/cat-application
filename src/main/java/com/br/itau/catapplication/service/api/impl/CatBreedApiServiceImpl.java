package com.br.itau.catapplication.service.api.impl;

import com.br.itau.catapplication.feign.CatApiFeignClient;
import com.br.itau.catapplication.feign.dto.BreedResponseDto;
import com.br.itau.catapplication.service.api.CatBreedApiService;
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
