package com.br.itau.cat.core.application.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
