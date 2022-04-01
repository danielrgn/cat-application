package com.br.itau.cat.collector.application.configuration;

import com.br.itau.cat.collector.application.listener.TaskListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskListenerConfig {

    @Bean
    public TaskListener taskListenerExecution() {
        return new TaskListener();
    }

}
