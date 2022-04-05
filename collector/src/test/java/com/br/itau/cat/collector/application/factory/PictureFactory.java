package com.br.itau.cat.collector.application.factory;

import com.br.itau.cat.core.application.entity.Breed;
import com.br.itau.cat.core.application.entity.Picture;

public class PictureFactory {

    public static Picture build() {
        return Picture.builder()
                .id("1")
                .url("url")
                .build();
    }

}
