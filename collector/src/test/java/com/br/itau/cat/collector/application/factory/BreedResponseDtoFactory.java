package com.br.itau.cat.collector.application.factory;

import com.br.itau.cat.collector.application.feign.dto.BreedResponseDto;

public class BreedResponseDtoFactory {

    public static BreedResponseDto build() {
        return BreedResponseDto.builder()
                .id("1")
                .description("test")
                .temperament("energy")
                .origin("br")
                .build();
    }

}
