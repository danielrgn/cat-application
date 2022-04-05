package com.br.itau.cat.collector.application.unity.feign.decoder;

import com.br.itau.cat.collector.application.exception.CatApiInternalServerErrorException;
import com.br.itau.cat.collector.application.factory.CatPictureResponseDtoFactory;
import com.br.itau.cat.collector.application.factory.PictureFactory;
import com.br.itau.cat.collector.application.feign.decoder.CatApiErrorDecoder;
import com.br.itau.cat.collector.application.mapper.CatPictureMapper;
import com.br.itau.cat.collector.application.service.api.CatPictureApiService;
import com.br.itau.cat.collector.application.service.impl.CatServiceImpl;
import com.br.itau.cat.collector.application.unity.UnityAbstractTest;
import com.br.itau.cat.core.application.entity.Breed;
import com.br.itau.cat.core.application.entity.Cat;
import com.br.itau.cat.core.application.repository.CatRepository;
import feign.FeignException;
import feign.Request;
import feign.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

class CatApiErrorDecoderTest extends UnityAbstractTest {

    private final static String PATH_ENDPOINT = "/";

    @InjectMocks
    private CatApiErrorDecoder catApiErrorDecoder;

    @ParameterizedTest(name = "shouldReturnExceptionForNonSpecificHttpStatus")
    @EnumSource(value = HttpStatus.class, names = { "INTERNAL_SERVER_ERROR"}, mode = EnumSource.Mode.EXCLUDE)
    void shouldReturnExceptionForNonSpecificHttpStatus(final HttpStatus httpStatus) {
        final Exception exceptionExpected = catApiErrorDecoder.decode(PATH_ENDPOINT, buildResponse(httpStatus));

        assertThat(exceptionExpected)
                .isNotNull()
                .isInstanceOf(FeignException.class);
    }

    @Test
    void shouldHandleKnownErrorWhenHttpStatusInternalServerError() {
        final Exception exceptionExpected = catApiErrorDecoder.decode(PATH_ENDPOINT, buildResponse(HttpStatus.INTERNAL_SERVER_ERROR));

        assertThat(exceptionExpected)
                .isNotNull()
                .isInstanceOf(CatApiInternalServerErrorException.class);
    }

    private Response buildResponse(final HttpStatus httpStatus) {
        return Response.builder()
                .status(httpStatus.value())
                .request(Request.create(Request.HttpMethod.GET,
                        "",
                        new HashMap<>(),
                        Request.Body.empty(),
                        null))
                .build();
    }

}