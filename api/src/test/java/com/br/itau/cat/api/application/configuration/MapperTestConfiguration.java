package com.br.itau.cat.api.application.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;

@TestConfiguration
@ComponentScan({"com.br.itau.cat.api.application.mapper"})
public class MapperTestConfiguration {
}
