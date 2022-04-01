package com.br.itau.cat.collector.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.br.itau.cat")
@EnableTask
@EnableFeignClients
@EntityScan("com.br.itau.cat.core.application.entity")
@EnableJpaRepositories("com.br.itau.cat.core.application.repository")
public class CatCollectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatCollectorApplication.class, args);
	}

}
