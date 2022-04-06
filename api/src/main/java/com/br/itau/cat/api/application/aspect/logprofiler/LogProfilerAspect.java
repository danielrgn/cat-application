package com.br.itau.cat.api.application.aspect.logprofiler;

import com.br.itau.cat.api.application.aspect.handler.*;
import com.br.itau.cat.api.application.aspect.handler.impl.SimpleTimeTracker;

import java.util.Objects;

public class LogProfilerAspect implements MethodInvocationHandler {
    private TimeTracker timeTracker;

    public LogProfilerAspect() {
        this(new SimpleTimeTracker());
    }

    public LogProfilerAspect(TimeTracker timeTracker) {
        this.timeTracker = Objects.requireNonNull(timeTracker);
    }

    public MethodInvocationObserver start(TargetMethod targetMethod) {
        String tag = this.buildTag(targetMethod);
        Timer timer = this.timeTracker.start(tag);
        return timer;
    }

    private String buildTag(TargetMethod targetMethod) {
        return targetMethod.getOwnerClassName() + "." + targetMethod.getName();
    }
}
