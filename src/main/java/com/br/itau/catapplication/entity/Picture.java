package com.br.itau.catapplication.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "picture")
public class Picture {

    @Id
    private String id;

    private String url;

    @Enumerated(EnumType.STRING)
    private PictureTypeEnum pictureType;

}
