package com.br.itau.cat.api.application.aspect.handler.impl;

import com.br.itau.cat.api.application.aspect.handler.TargetMethod;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class TargetMethodWrapper implements TargetMethod {
    private final Method targetMethod;
    private final Class<? extends Object> ownewClass;
    private final MethodInvocation invocation;

    public TargetMethodWrapper(MethodInvocation invocation) throws NoSuchMethodException, SecurityException {
        this.invocation = invocation;
        Method original = invocation.getMethod();
        this.ownewClass = invocation.getThis().getClass();
        this.targetMethod = this.ownewClass.getMethod(original.getName(), original.getParameterTypes());
    }

    public String getOwnerClassName() {
        return this.ownewClass.getSimpleName();
    }

    public String getName() {
        return this.targetMethod.getName();
    }

}
