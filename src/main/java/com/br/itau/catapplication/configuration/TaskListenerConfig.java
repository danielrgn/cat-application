package com.br.itau.catapplication.configuration;

import com.br.itau.catapplication.listener.TaskListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskListenerConfig {

    @Bean
    public TaskListener taskListenerExecution() {
        return new TaskListener();
    }

}
