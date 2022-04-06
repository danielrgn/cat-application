package com.br.itau.cat.api.application.aspect.handler;

public interface MethodInvocationObserver {
    void success(Object var1);

    void error(Throwable var1);
}
