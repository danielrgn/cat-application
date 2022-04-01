package com.br.itau.catapplication.service.impl;

import com.br.itau.catapplication.entity.Breed;
import com.br.itau.catapplication.entity.Cat;
import com.br.itau.catapplication.entity.Picture;
import com.br.itau.catapplication.repository.CatRepository;
import com.br.itau.catapplication.service.CatPictureService;
import com.br.itau.catapplication.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatPictureService catPictureService;

    @Autowired
    private CatRepository catRepository;

    @Override
    public void saveCatsAndPictures(final Breed breed) {
        final List<Picture> catPictures = catPictureService.getPictures(breed.getId());

        catRepository.save(Cat.builder().breed(breed).pictures(catPictures).build());
    }

}
