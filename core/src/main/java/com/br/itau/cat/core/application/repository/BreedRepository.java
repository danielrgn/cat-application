package com.br.itau.cat.core.application.repository;

import com.br.itau.cat.core.application.entity.Breed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreedRepository extends JpaRepository<Breed, String> {

    List<Breed> findByTemperamentContaining(String temperament);

    List<Breed> findByOriginContaining(String origin);
}
