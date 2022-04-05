package com.br.itau.cat.collector.application.service;

import com.br.itau.cat.collector.application.enums.CatCategoryEnum;
import com.br.itau.cat.core.application.entity.Breed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CollectCatInfoService {

    @Autowired
    private BreedService breedService;

    @Autowired
    private CatService catService;

    public void execute() {
        log.info("Start collect breeds");
        final List<Breed> breeds = breedService.collectBreeds();

        breeds.forEach(breed -> {
            log.info("Start save cats and pictures by breed {}", breed);
            catService.saveCatsAndPictures(breed);
        });

        log.info("Start save cats and pictures by hats");
        catService.saveCatsAndPictures(CatCategoryEnum.HATS);

        log.info("Start save cats and pictures by sunglasses");
        catService.saveCatsAndPictures(CatCategoryEnum.SUNGLASSES);
    }
}
