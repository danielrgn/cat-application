package com.br.itau.catapplication.mapper;

import com.br.itau.catapplication.entity.Picture;
import com.br.itau.catapplication.feign.dto.CatPictureResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatPictureMapper {

    List<Picture> fromCatPictureResponseDtoList(final List<CatPictureResponseDto> catPictureResponseDtoList);

    Picture catPictureResponseDtoToPicture(final CatPictureResponseDto catPictureResponseDto);
}