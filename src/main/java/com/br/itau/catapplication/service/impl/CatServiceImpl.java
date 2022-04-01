package com.br.itau.catapplication.service.impl;

import com.br.itau.catapplication.entity.Breed;
import com.br.itau.catapplication.entity.Cat;
import com.br.itau.catapplication.entity.Picture;
import com.br.itau.catapplication.enums.CatCategoryEnum;
import com.br.itau.catapplication.feign.dto.CatPictureResponseDto;
import com.br.itau.catapplication.mapper.CatPictureMapper;
import com.br.itau.catapplication.repository.CatRepository;
import com.br.itau.catapplication.service.api.CatPictureApiService;
import com.br.itau.catapplication.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatPictureApiService catPictureApiService;

    @Autowired
    private CatRepository catRepository;

    @Autowired
    private CatPictureMapper catPictureMapper;

    @Override
    public void saveCatsAndPictures(final Breed breed) {
        final List<CatPictureResponseDto> imagesByBreedIds = catPictureApiService.getPicturesByBreedId(breed.getId());
        final List<Picture> catPictureList = catPictureMapper.fromCatPictureResponseDtoList(imagesByBreedIds);

        catRepository.save(Cat.builder().breed(breed).pictures(catPictureList).build());
    }

    @Override
    public void saveCatsAndPictures(final CatCategoryEnum catCategoryEnum) {
        final List<CatPictureResponseDto> imagesByBreedIds = catPictureApiService.getPicturesByCategoryId(catCategoryEnum.getId());

        imagesByBreedIds.forEach(catPicture -> {
            final Breed breed = catPicture.getBreeds().size() > 0 ? catPicture.getBreeds().get(0) : null;
            final List<Picture> pictureList = Arrays.asList(Picture.builder()
                    .id(catPicture.getId())
                    .url(catPicture.getUrl())
                    .build());

            catRepository.save(Cat.builder().breed(breed).pictures(pictureList).build());
        });
    }

}
