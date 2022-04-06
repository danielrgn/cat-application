# Cat Application

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
- Spring / Spring Cloud Task
- Spring Data / Hibernate / JPA / H2
- Spring Open Feign

### Arquitetura do microserviço
Este microserviço é composto pelos módulos:

| Módulo             | Função
|--------------------|--------
| *Collector* | Faz a coleta de informações da API `The Cats API` e salva no banco de dados
| *API*       | Recebe requisições síncronas e retorna os dados coletados pelo módulo `collector`
| *Core*      | Domínio e componentes comuns da aplicação

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

[1]: https://thecatapi.com/

## Testes e cobertura

**Executar o coverage:**

```sh
sdk use java 11.0.2-open
mvnw clean install jacoco:report
```