package com.br.itau.cat.api.application.integration.v1.controller;

import com.br.itau.cat.api.application.exception.BreedNotFoundException;
import com.br.itau.cat.api.application.factory.BreedResponseDtoFactory;
import com.br.itau.cat.api.application.integration.IntegrationAbstractTest;
import com.br.itau.cat.api.application.service.BreedService;
import com.br.itau.cat.api.application.v1.controller.impl.BreedControllerImpl;
import com.br.itau.cat.core.application.repository.BreedRepository;
import com.br.itau.cat.core.application.repository.CatRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {BreedControllerImpl.class})
@DisplayName("Test Controller Breed")
class BreedControllerImplTest extends IntegrationAbstractTest {

    private final static String PATH_RESOURCE = "/v1/breed";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BreedService breedService;

    @MockBean
    private CatRepository catRepository;

    @MockBean
    private BreedRepository breedRepository;

    @Test
    @DisplayName("Should return all breeds")
    @SneakyThrows
    public void shouldReturnAllBreeds() {
        when(breedService.getAll()).thenReturn(BreedResponseDtoFactory.buildList());

        mockMvc.perform(get(PATH_RESOURCE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", equalTo("abys")))
                .andExpect(jsonPath("$[0].origin", equalTo("Egypt")))
                .andExpect(jsonPath("$[0].temperament", equalTo("Active, Energetic, Independent, Intelligent, Gentle")))
                .andExpect(jsonPath("$[1].id", equalTo("beng")))
                .andExpect(jsonPath("$[1].origin", equalTo("United States")))
                .andExpect(jsonPath("$[1].temperament", equalTo("Alert, Agile, Energetic, Demanding, Intelligent")))
                .andExpect(jsonPath("$[2].id", equalTo("orie")))
                .andExpect(jsonPath("$[2].origin", equalTo("United States")))
                .andExpect(jsonPath("$[2].temperament", equalTo("Energetic, Affectionate, Intelligent, Social, Playful, Curious")));
    }

    @Test
    @DisplayName("Should return status not found when get all breeds when throw not found exception")
    @SneakyThrows
    public void givenGetAllBreedsShouldReturnNotFoundWhenThrowNotFoundException() {
        when(breedService.getAll()).thenThrow(BreedNotFoundException.class);

        mockMvc.perform(get(PATH_RESOURCE))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$[0].errorMessage", equalTo("You attempted to get a Breed, but did not find any.")));
    }

    @Test
    @DisplayName("Should return breed by id")
    @SneakyThrows
    public void shouldReturnBreedById() {
        when(breedService.getById(any())).thenReturn(BreedResponseDtoFactory.buildList().get(0));

        mockMvc.perform(get(PATH_RESOURCE.concat("/{id}"), "abys"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo("abys")))
                .andExpect(jsonPath("$.origin", equalTo("Egypt")))
                .andExpect(jsonPath("$.temperament", equalTo("Active, Energetic, Independent, Intelligent, Gentle")));
    }

    @Test
    @DisplayName("Should return status not found when get breed by id when throw not found exception")
    @SneakyThrows
    public void givenGetBreedByIdShouldReturnNotFoundWhenThrowNotFoundException() {
        when(breedService.getById(any())).thenThrow(BreedNotFoundException.class);

        mockMvc.perform(get(PATH_RESOURCE.concat("/{id}"), "abys"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$[0].errorMessage", equalTo("You attempted to get a Breed, but did not find any.")));
    }

    @Test
    @DisplayName("Should return breeds by temperament")
    @SneakyThrows
    public void shouldReturnBreedsByTemperament() {
        when(breedService.getByTemperament(any())).thenReturn(Collections.singletonList(BreedResponseDtoFactory.buildList().get(2)));

        mockMvc.perform(get(PATH_RESOURCE.concat("/search")).param("temperament", "Affectionate"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo("orie")))
                .andExpect(jsonPath("$[0].origin", equalTo("United States")))
                .andExpect(jsonPath("$[0].temperament", equalTo("Energetic, Affectionate, Intelligent, Social, Playful, Curious")));
    }

    @Test
    @DisplayName("Should return status not found when get breeds by temperament when throw not found exception")
    @SneakyThrows
    public void givenGetBreedsByTemperamentShouldReturnNotFoundWhenThrowNotFoundException() {
        when(breedService.getByTemperament(any())).thenThrow(BreedNotFoundException.class);

        mockMvc.perform(get(PATH_RESOURCE.concat("/search")).param("temperament", "Affectionate"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$[0].errorMessage", equalTo("You attempted to get a Breed, but did not find any.")));
    }

    @Test
    @DisplayName("Should return breeds by origin")
    @SneakyThrows
    public void shouldReturnBreedsByOrigin() {
        when(breedService.getByOrigin(any())).thenReturn(List.of(BreedResponseDtoFactory.buildList().get(1),BreedResponseDtoFactory.buildList().get(2)));

        mockMvc.perform(get(PATH_RESOURCE.concat("/search")).param("origin", "United States"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", equalTo("beng")))
                .andExpect(jsonPath("$[0].origin", equalTo("United States")))
                .andExpect(jsonPath("$[0].temperament", equalTo("Alert, Agile, Energetic, Demanding, Intelligent")))
                .andExpect(jsonPath("$[1].id", equalTo("orie")))
                .andExpect(jsonPath("$[1].origin", equalTo("United States")))
                .andExpect(jsonPath("$[1].temperament", equalTo("Energetic, Affectionate, Intelligent, Social, Playful, Curious")));;
    }

    @Test
    @DisplayName("Should return status not found when get breeds by origin when throw not found exception")
    @SneakyThrows
    public void givenGetBreedsByOriginShouldReturnNotFoundWhenThrowNotFoundException() {
        when(breedService.getByOrigin(any())).thenThrow(BreedNotFoundException.class);

        mockMvc.perform(get(PATH_RESOURCE.concat("/search")).param("origin", "United States"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$[0].errorMessage", equalTo("You attempted to get a Breed, but did not find any.")));
    }

    @Test
    @DisplayName("Should throw method not allowed when try to use another verb http")
    @SneakyThrows
    public void shouldThrowMethodNotAllowedWhenTryToUseAnotherVerbHttp() {
        mockMvc.perform(post(PATH_RESOURCE))
                .andExpect(status().isMethodNotAllowed())
                .andExpect(jsonPath("$[0].errorMessage", equalTo("Method not allowed.")));
    }

    @Test
    @DisplayName("Should return status not found when get all breeds when throw not found exception")
    @SneakyThrows
    public void givenGetAllBreedsShouldReturnInternalServerErrorWhenThrowException() {
        when(breedService.getAll()).thenThrow(RuntimeException.class);

        mockMvc.perform(get(PATH_RESOURCE))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$[0].errorMessage", 
                        equalTo("Was encountered an error when processing your request. We apologize for the inconvenience.")));
    }
}