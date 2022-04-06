package com.br.itau.cat.api.application.v1.controller.impl;

import com.br.itau.cat.api.application.aspect.logprofiler.LogProfiler;
import com.br.itau.cat.api.application.service.BreedService;
import com.br.itau.cat.api.application.v1.controller.BreedController;
import com.br.itau.cat.api.application.v1.dto.BreedResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/breed")
public class BreedControllerImpl implements BreedController {

    @Autowired
    private BreedService breedService;

    @LogProfiler
    @GetMapping
    @Override
    public ResponseEntity<List<?>> getAllBreeds() {
        final List<BreedResponseDto> breedDtoList = this.breedService.getAll();
        return ResponseEntity.ok(breedDtoList);
    }

    @LogProfiler
    @GetMapping(value = "{id}")
    @Override
    public ResponseEntity<?> getBreedById(@PathVariable String id) {
        final BreedResponseDto breedDto = this.breedService.getById(id);
        return ResponseEntity.ok(breedDto);
    }

    @LogProfiler
    @GetMapping(value = "/search", params = "temperament")
    @Override
    public ResponseEntity<?> getBreedsByTemperament(@RequestParam String temperament) {
        final List<BreedResponseDto> breedDtoList = this.breedService.getByTemperament(temperament);
        return ResponseEntity.ok(breedDtoList);
    }

    @LogProfiler
    @GetMapping(value = "/search", params = "origin")
    @Override
    public ResponseEntity<?> getBreedsByOrigin(@RequestParam String origin) {
        final List<BreedResponseDto> breedDtoList = this.breedService.getByOrigin(origin);
        return ResponseEntity.ok(breedDtoList);
    }

}
