package com.br.itau.cat.collector.application.service;

import com.br.itau.cat.core.application.entity.Breed;
import com.br.itau.cat.collector.application.enums.CatCategoryEnum;

public interface CatService {

    void saveCatsAndPictures(Breed breed);

    void saveCatsAndPictures(CatCategoryEnum catCategoryEnum);
}
