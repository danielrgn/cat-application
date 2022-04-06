package com.br.itau.cat.collector.application.unity.feign.decoder;

import com.br.itau.cat.collector.application.exception.CatApiInternalServerErrorException;
import com.br.itau.cat.collector.application.feign.decoder.CatApiErrorDecoder;
import com.br.itau.cat.collector.application.unity.UnityAbstractTest;
import feign.FeignException;
import feign.Request;
import feign.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

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