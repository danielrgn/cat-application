package com.br.itau.cat.collector.application.factory;

import com.br.itau.cat.core.application.entity.Breed;

public class BreedFactory {

    public static Breed build() {
        return Breed.builder()
                .id("1")
                .description("test")
                .temperament("energy")
                .origin("br")
                .build();
    }

}
