package com.br.itau.cat.collector.application.factory;

import com.br.itau.cat.collector.application.feign.dto.CatPictureResponseDto;

import java.util.Arrays;

public class CatPictureResponseDtoFactory {

    public static CatPictureResponseDto build() {
        return CatPictureResponseDto.builder()
                .id("1")
                .url("url")
                .breeds(Arrays.asList(BreedFactory.build(), BreedFactory.build()))
                .build();
    }

}
