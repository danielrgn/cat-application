package com.br.itau.catapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PictureTypeEnum {
    DEFAULT(0),
    GLASSES(1),
    HAT(4);

    private Integer id;
}
