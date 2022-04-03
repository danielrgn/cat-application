package com.br.itau.cat.api.application.v1.controller.handler;

import com.br.itau.cat.api.application.exception.BreedNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class BaseControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public List<ResponseError.ErrorMessage> exception(final Exception ex) {
        return Collections.singletonList(ResponseError.ErrorMessage.builder()
                .errorMessage(
                        "Was encountered an error when processing your request."
                                + " We apologize for the inconvenience.")
                .build());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public List<ResponseError.ErrorMessage> exception(
            final HttpRequestMethodNotSupportedException ex) {

        return Collections.singletonList(ResponseError.ErrorMessage.builder()
                .errorMessage("Method not allowed")
                .build());
    }

    @ExceptionHandler(BreedNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public List<ResponseError.ErrorMessage> exception(final BreedNotFoundException ex) {
        return Collections.singletonList(ResponseError.ErrorMessage.builder()
                .errorMessage("You attempted to get a Breed, but did not find any")
                .build());
    }
}