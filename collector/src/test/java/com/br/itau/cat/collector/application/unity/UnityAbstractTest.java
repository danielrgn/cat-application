package com.br.itau.cat.collector.application.unity;

import com.br.itau.cat.collector.application.factory.BreedFactory;
import com.br.itau.cat.collector.application.factory.BreedResponseDtoFactory;
import com.br.itau.cat.collector.application.factory.CatPictureResponseDtoFactory;
import com.br.itau.cat.collector.application.feign.dto.BreedResponseDto;
import com.br.itau.cat.collector.application.feign.dto.CatPictureResponseDto;
import com.br.itau.cat.core.application.entity.Breed;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith({MockitoExtension.class})
public abstract class UnityAbstractTest {

    protected List<BreedResponseDto> getBreedResponseDtoList() {
        return List.of(BreedResponseDtoFactory.build(), BreedResponseDtoFactory.build());
    }

    protected List<Breed> getBreedList() {
        return List.of(BreedFactory.build(), BreedFactory.build());
    }

    protected List<CatPictureResponseDto> getCatPictureResponseDtoList() {
        return List.of(CatPictureResponseDtoFactory.build(), CatPictureResponseDtoFactory.build());
    }

}
