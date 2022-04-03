package com.br.itau.cat.core.application.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
