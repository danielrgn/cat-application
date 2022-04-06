package com.br.itau.cat.api.application.aspect.handler.impl;

import com.br.itau.cat.api.application.aspect.handler.MethodInvocationHandler;
import com.br.itau.cat.api.application.aspect.handler.MethodInvocationObserver;
import com.br.itau.cat.api.application.aspect.handler.TargetMethod;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Collections;
import java.util.Map;
import java.util.function.Predicate;

public class MethodInvocationInpector implements MethodInterceptor {
    private MethodInvocationHandler handler;
    private final Map<Class<? extends Throwable>, Predicate<? extends Throwable>> conditions;

    public MethodInvocationInpector(MethodInvocationHandler handler) {
        this.handler = handler;
        this.conditions = Collections.emptyMap();
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {
        TargetMethod targetMethod = new TargetMethodWrapper(invocation);
        MethodInvocationObserver observer = this.handler.start(targetMethod);

        try {
            Object callResult = invocation.proceed();
            observer.success(callResult);
            return callResult;
        } catch (Throwable var7) {
            Predicate<Throwable> condition = (Predicate)this.conditions.get(var7.getClass());
            if (condition != null && !condition.test(var7)) {
                observer.success((Object)null);
            } else {
                observer.error(var7);
            }

            throw var7;
        }
    }
}
