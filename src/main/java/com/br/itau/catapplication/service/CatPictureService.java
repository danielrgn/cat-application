package com.br.itau.catapplication.service;

import com.br.itau.catapplication.entity.Breed;
import com.br.itau.catapplication.entity.Picture;
import com.br.itau.catapplication.feign.dto.CatPictureResponseDto;

import java.util.List;

public interface CatPictureService {

    List<Picture> getPictures(String breedId);
}
