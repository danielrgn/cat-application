package com.br.itau.cat.api.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.br.itau.cat")
@EntityScan("com.br.itau.cat.core.application.entity")
@EnableJpaRepositories("com.br.itau.cat.core.application.repository")
public class CatApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatApiApplication.class, args);
	}

}
