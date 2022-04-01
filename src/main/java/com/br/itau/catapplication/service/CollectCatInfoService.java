package com.br.itau.catapplication.service;

import com.br.itau.catapplication.entity.Breed;
import com.br.itau.catapplication.enums.CatCategoryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectCatInfoService {

    @Autowired
    private BreedService breedService;

    @Autowired
    private CatService catService;

    public void execute() {
        final List<Breed> breeds = breedService.collectBreeds();

        breeds.forEach(breed -> catService.saveCatsAndPictures(breed));

        catService.saveCatsAndPictures(CatCategoryEnum.HATS);
        catService.saveCatsAndPictures(CatCategoryEnum.SUNGLASSES);
    }
}
