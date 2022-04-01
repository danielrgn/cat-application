package com.br.itau.cat.collector.application.feign.dto;

import lombok.Data;

@Data
public class BreedResponseDto {

    private String id;

    private String description;

    private String temperament;

    private String origin;

}
