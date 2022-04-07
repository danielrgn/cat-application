# Cat Application

> Para a organização do desenvolvimento do projeto foi criado uma issue com um [TODO LIST][2]

## Requisitos
```sh
Java 11
Docker / Docker Compose
```

## Instalação OS X & Linux:

**Java 11 - SDKMAN:**

```sh
https://sdkman.io/install
sdk i java 11.0.2-open
```

**Docker compose:**

```sh
https://docs.docker.com/compose/install/
```

## Integrações
- Banco de dados MySQL
- [The cats API][1]

## Desenvolvimento
### Tecnologias
- Spring / Spring Cloud Task / Spring AOP
- Spring Data / Hibernate / JPA / H2
- Spring Open Feign

### Arquitetura do microserviço
Este microserviço é composto pelos módulos:

| Módulo             | Função
|--------------------|--------
| *Collector* | Faz a coleta de informações da API `The Cats API` e salva no banco de dados
| *API*       | Recebe requisições síncronas e retorna os dados coletados pelo módulo `collector`
| *Core*      | Domínio e componentes comuns da aplicação

![arch_cats drawio](https://user-images.githubusercontent.com/7592397/162115875-c01c62bc-cb1e-4f43-96fa-4174b8d9ac59.png)

## Compilando o projeto

Acessar a pasta raiz do projeto:

**Compilar o projeto:**

```sh
sdk use java 11.0.2-open
mvnw clean package
```

Antes disso iremos subir módulo Collector, vamos iniciar o banco de dados MySQL local:

```sh
docker-compose up -d db
```

Com o banco de dados iniciado, agora podemos executar o módulo collector:

```sh
docker-compose up cat_collector_application
```

Quando terminar de executar a aplicação, podemos iniciar a nossa API:

```sh
docker-compose up -d cat_api_application
```

## Cat API

**Documentação da API:**

```
http://localhost:8082/swagger-ui.html#/
```

**Collection Postman:**

```
api/src/main/resources/postman/Cat_Api_Application.postman_collection.json
```

## Testes e cobertura

**Executar o coverage:**

```sh
sdk use java 11.0.2-open
mvnw clean install jacoco:report
```

Para testes de performance e testes de carga poderia-se utilizar o jmeter, gatling ou k6. No caso de testes de comportamento poderia-se utilizar o Cucumber. E para testes de integração/aceitação poderia-se utilizar o TestContainers. 

## Logs

Logs da execução do módulo `collector`:
![image](https://user-images.githubusercontent.com/7592397/162113463-4a47ebe1-9a11-448a-a952-7329bd57d3a8.png)

Logs das métricas de execução de cada endpoint da API:

![image](https://user-images.githubusercontent.com/7592397/162075607-e20847f6-6e3c-46e9-a3e7-99014c9f60de.png)

[1]: https://thecatapi.com/
[2]: https://github.com/danielrgn/cat-application/issues/1
