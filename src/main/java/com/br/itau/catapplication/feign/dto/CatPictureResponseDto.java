package com.br.itau.catapplication.feign.dto;

import com.br.itau.catapplication.entity.Breed;
import lombok.Data;

import java.util.List;

@Data
public class CatPictureResponseDto {

    private String id;

    private List<Breed> breeds;

    private String url;

}
