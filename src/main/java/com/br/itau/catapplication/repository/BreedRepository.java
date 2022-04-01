package com.br.itau.catapplication.repository;

import com.br.itau.catapplication.entity.Breed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreedRepository extends JpaRepository<Breed, String> {
}
