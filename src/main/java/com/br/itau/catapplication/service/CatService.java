package com.br.itau.catapplication.service;

import com.br.itau.catapplication.entity.Breed;
import com.br.itau.catapplication.enums.CatCategoryEnum;

public interface CatService {

    void saveCatsAndPictures(Breed breed);

    void saveCatsAndPictures(CatCategoryEnum catCategoryEnum);
}
