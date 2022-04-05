package com.br.itau.cat.core.application.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
