package com.br.itau.catapplication.feign.decoder;

import com.br.itau.catapplication.exception.CatApiInternalServerErrorException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CatApiErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder delegate = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        final HttpStatus statusCode = HttpStatus.valueOf(response.status());

        switch (statusCode) {
            case INTERNAL_SERVER_ERROR:
                return new CatApiInternalServerErrorException();
            default:
                return delegate.decode(methodKey, response);
        }
    }
}
