package com.br.itau.cat.collector.application.mapper;

import com.br.itau.cat.core.application.entity.Picture;
import com.br.itau.cat.collector.application.feign.dto.CatPictureResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatPictureMapper {

    List<Picture> fromCatPictureResponseDtoList(final List<CatPictureResponseDto> catPictureResponseDtoList);

    Picture catPictureResponseDtoToPicture(final CatPictureResponseDto catPictureResponseDto);
}