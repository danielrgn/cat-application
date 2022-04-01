package com.br.itau.catapplication.service.impl;

import com.br.itau.catapplication.entity.Picture;
import com.br.itau.catapplication.feign.CatApiFeignClient;
import com.br.itau.catapplication.feign.dto.CatPictureResponseDto;
import com.br.itau.catapplication.mapper.BreedMapper;
import com.br.itau.catapplication.mapper.CatPictureMapper;
import com.br.itau.catapplication.service.CatPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatPictureServiceImpl implements CatPictureService {

    @Autowired
    private CatApiFeignClient catApiFeignClient;

    @Autowired
    private CatPictureMapper catPictureMapper;

    @Override
    public List<Picture> getPictures(final String breedId) {
        final List<CatPictureResponseDto> imagesByBreedIds = catApiFeignClient.getImagesByBreedIds(breedId);
        return catPictureMapper.fromCatPictureResponseDtoList(imagesByBreedIds);
    }

}
