package com.br.itau.catapplication.service.impl;

import com.br.itau.catapplication.entity.Breed;
import com.br.itau.catapplication.feign.dto.BreedResponseDto;
import com.br.itau.catapplication.mapper.BreedMapper;
import com.br.itau.catapplication.repository.BreedRepository;
import com.br.itau.catapplication.service.BreedService;
import com.br.itau.catapplication.service.api.CatBreedApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedServiceImpl implements BreedService {

    @Autowired
    private CatBreedApiService catBreedApiService;

    @Autowired
    private BreedRepository breedRepository;

    @Autowired
    private BreedMapper breedMapper;

    @Override
    public List<Breed> collectBreeds() {
        final List<BreedResponseDto> breedResponseDtos = catBreedApiService.getAllBreeds();

        final List<Breed> breedList = breedMapper.fromBreedResponseDtoList(breedResponseDtos);

        return breedRepository.saveAll(breedList);
    }

}
