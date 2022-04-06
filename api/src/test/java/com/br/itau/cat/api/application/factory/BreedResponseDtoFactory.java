package com.br.itau.cat.api.application.factory;

import com.br.itau.cat.api.application.v1.dto.BreedResponseDto;

import java.util.List;

public class BreedResponseDtoFactory {

    public static BreedResponseDto build() {
        return BreedResponseDto.builder()
                .id("1")
                .description("test")
                .temperament("energy")
                .origin("br")
                .build();
    }

    public static List<BreedResponseDto> buildList() {
        return List.of(BreedResponseDto.builder()
                        .id("abys").description("Abyssinian").origin("Egypt").temperament("Active, Energetic, Independent, Intelligent, Gentle")
                        .build(),
                BreedResponseDto.builder()
                        .id("beng").description("Bengal").origin("United States").temperament("Alert, Agile, Energetic, Demanding, Intelligent")
                        .build(),
                BreedResponseDto.builder()
                        .id("orie").description("Oriental").origin("United States").temperament("Energetic, Affectionate, Intelligent, Social, Playful, Curious")
                        .build());
    }

}
