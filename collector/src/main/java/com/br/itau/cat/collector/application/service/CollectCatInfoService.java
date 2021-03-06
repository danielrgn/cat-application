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

        breeds.forEach(breed -> catService.saveCatsAndPictures(breed));

        catService.saveCatsAndPictures(CatCategoryEnum.HATS);
        catService.saveCatsAndPictures(CatCategoryEnum.SUNGLASSES);
    }
}
