package com.br.itau.catapplication.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "breed")
public class Breed {

    @Id
    private String id;

    private String description;

    private String temperament;

    private String origin;

}
