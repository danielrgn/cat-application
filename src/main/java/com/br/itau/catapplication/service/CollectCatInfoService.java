package com.br.itau.catapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectCatInfoService {

    @Autowired
    private BreedService breedService;

    public void execute() {
        breedService.collectBreeds();
    }
}
