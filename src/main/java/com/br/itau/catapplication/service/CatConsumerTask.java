package com.br.itau.catapplication.service;

import org.springframework.stereotype.Component;

@Component
public class CatConsumerTask {
    public void execute() {
        System.out.println("teste");
    }
}
