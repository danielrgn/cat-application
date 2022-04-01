package com.br.itau.cat.core.application.entity;

import lombok.Data;
import org.springframework.data.domain.Persistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "breed")
public class Breed implements Persistable<String> {

    @Id
    private String id;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String temperament;

    private String origin;

    @Override
    public boolean isNew() {
        return true;
    }

}
