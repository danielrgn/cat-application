package com.br.itau.catapplication.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "picture")
public class Picture implements Persistable<String> {

    @Id
    private String id;

    private String url;

    @Override
    public boolean isNew() {
        return true;
    }

}
