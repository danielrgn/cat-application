package com.br.itau.cat.api.application.v1.controller;

import com.br.itau.cat.api.application.v1.dto.BreedResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(tags = "Breed")
@ApiOperation("Breed")
public interface BreedController {

    @ApiOperation(value = "Get all breeds", response = BreedResponseDto.class)
    ResponseEntity<List<?>> getAllBreeds();

    @ApiOperation(value = "Get breed by id", response = BreedResponseDto.class)
    ResponseEntity<?> getBreedById(String id);

    @ApiOperation(value = "Get breeds by search", response = BreedResponseDto.class)
    ResponseEntity<?> getBreedsByTemperament(String temperament);

    @ApiOperation(value = "Get breeds by search", response = BreedResponseDto.class)
    ResponseEntity<?> getBreedsByOrigin(String origin);

}
