package com.br.itau.cat.collector.application.feign.dto;

import lombok.*;

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
