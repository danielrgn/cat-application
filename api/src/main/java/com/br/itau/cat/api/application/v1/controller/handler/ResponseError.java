package com.br.itau.cat.api.application.v1.controller.handler;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ResponseError {

    private List<ErrorMessage> errorMessages;

    @Builder
    @Getter
    public static class ErrorMessage {
        private String errorMessage;
    }

}
