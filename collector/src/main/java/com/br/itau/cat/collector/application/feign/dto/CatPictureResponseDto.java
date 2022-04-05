package com.br.itau.cat.collector.application.feign.dto;

import com.br.itau.cat.core.application.entity.Breed;
import lombok.*;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CatPictureResponseDto {

    private String id;

    private List<Breed> breeds;

    private String url;

}
