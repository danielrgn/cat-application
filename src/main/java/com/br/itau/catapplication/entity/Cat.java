package com.br.itau.catapplication.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "cat")
public class Cat implements Persistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Breed breed;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_id")
    private List<Picture> pictures;

    @Override
    public boolean isNew() {
        return true;
    }

}
