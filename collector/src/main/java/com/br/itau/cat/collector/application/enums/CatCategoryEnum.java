package com.br.itau.cat.collector.application.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CatCategoryEnum {

    HATS(1L),
    SUNGLASSES(4L);

    private Long id;

}
