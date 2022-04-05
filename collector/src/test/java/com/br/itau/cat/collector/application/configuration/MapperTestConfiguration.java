package com.br.itau.cat.collector.application.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;

@TestConfiguration
@ComponentScan({"com.br.itau.cat.collector.application.mapper"})
public class MapperTestConfiguration {
}
