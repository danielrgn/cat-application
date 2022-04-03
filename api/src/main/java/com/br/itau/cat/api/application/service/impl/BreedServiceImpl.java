package com.br.itau.cat.api.application.service.impl;

import com.br.itau.cat.api.application.exception.BreedNotFoundException;
import com.br.itau.cat.api.application.mapper.BreedMapper;
import com.br.itau.cat.api.application.service.BreedService;
import com.br.itau.cat.api.application.v1.dto.BreedResponseDto;
import com.br.itau.cat.core.application.entity.Breed;
import com.br.itau.cat.core.application.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreedServiceImpl implements BreedService {

    @Autowired
    private BreedRepository breedRepository;

    @Autowired
    private BreedMapper breedMapper;

    @Override
    public List<BreedResponseDto> getAll() {
        final List<Breed> breeds = this.breedRepository.findAll();

        if (breeds.isEmpty()) {
            throw new BreedNotFoundException();
        }

        return breedMapper.fromBreedList(breeds);
    }

    @Override
    public BreedResponseDto getById(final String id) {
        final Optional<Breed> breed = this.breedRepository.findById(id);

        if (breed.isPresent()) {
            return breedMapper.breedToBreedResponseDto(breed.get());
        }

        throw new BreedNotFoundException();
    }

    @Override
    public List<BreedResponseDto> getByTemperament(final String temperament) {
        final List<Breed> breeds = this.breedRepository.findByTemperamentContaining(temperament);

        if (breeds.isEmpty()) {
            throw new BreedNotFoundException();
        }

        return breedMapper.fromBreedList(breeds);
    }

    @Override
    public List<BreedResponseDto> getByOrigin(final String origin) {
        final List<Breed> breeds = this.breedRepository.findByOriginContaining(origin);

        if (breeds.isEmpty()) {
            throw new BreedNotFoundException();
        }

        return breedMapper.fromBreedList(breeds);
    }

}
