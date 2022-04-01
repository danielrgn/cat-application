package com.br.itau.cat.collector.application.service.impl;

import com.br.itau.cat.collector.application.feign.dto.BreedResponseDto;
import com.br.itau.cat.collector.application.mapper.BreedMapper;
import com.br.itau.cat.collector.application.service.BreedService;
import com.br.itau.cat.collector.application.service.api.CatBreedApiService;
import com.br.itau.cat.core.application.entity.Breed;
import com.br.itau.cat.core.application.repository.BreedRepository;
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
