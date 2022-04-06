package com.br.itau.cat.api.application.configuration;

import com.br.itau.cat.api.application.aspect.handler.impl.MethodInvocationInpector;
import com.br.itau.cat.api.application.aspect.logprofiler.LogProfiler;
import com.br.itau.cat.api.application.aspect.logprofiler.LogProfilerAspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectLogsConfiguration {

    @Bean
    public Advisor logProfilerAdvisor() {
        final var pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(public * *(..)) "
                + "&& @annotation(" + LogProfiler.class.getName() + ")");
        final var advice = new MethodInvocationInpector(new LogProfilerAspect());
        return new DefaultPointcutAdvisor(pointcut, advice);
    }

}