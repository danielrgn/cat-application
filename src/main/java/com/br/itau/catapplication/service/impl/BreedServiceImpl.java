package com.br.itau.catapplication.service.impl;

import com.br.itau.catapplication.entity.Breed;
import com.br.itau.catapplication.feign.CatApiFeignClient;
import com.br.itau.catapplication.mapper.BreedMapper;
import com.br.itau.catapplication.repository.BreedRepository;
import com.br.itau.catapplication.service.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedServiceImpl implements BreedService {

    @Autowired
    private CatApiFeignClient catApiFeignClient;

    @Autowired
    private BreedRepository breedRepository;

    @Autowired
    private BreedMapper breedMapper;

    @Override
    public void collectBreeds() {
        catApiFeignClient.getAllBreeds()
            .ifPresent(breedResponseDtos -> {
                final List<Breed> breedList = breedMapper.fromBreedResponseDtoList(breedResponseDtos);
                breedRepository.saveAll(breedList);
            });
    }

}
