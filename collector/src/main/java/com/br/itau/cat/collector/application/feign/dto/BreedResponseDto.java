package com.br.itau.cat.collector.application.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BreedResponseDto {

    private String id;

    private String description;

    private String temperament;

    private String origin;

}
