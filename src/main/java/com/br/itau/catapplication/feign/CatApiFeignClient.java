package com.br.itau.catapplication.feign;

import com.br.itau.catapplication.feign.dto.BreedResponseDto;
import com.br.itau.catapplication.feign.dto.CatPictureResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "catApi", url = "${cat-api.url}")
public interface CatApiFeignClient {

    @GetMapping(value = "/breeds", consumes = "application/json", produces = "application/json")
    List<BreedResponseDto> getAllBreeds();

    @GetMapping(value = "/images/search?limit=3&category_ids={categoryId}", consumes = "application/json", produces = "application/json")
    List<CatPictureResponseDto> getImagesByCategoryIds(@PathVariable("categoryId") Long categoryId);

    @GetMapping(value = "/images/search?limit=3&breed_ids={breedId}", consumes = "application/json", produces = "application/json")
    List<CatPictureResponseDto> getImagesByBreedIds(@PathVariable("breedId") String breedId);
}
