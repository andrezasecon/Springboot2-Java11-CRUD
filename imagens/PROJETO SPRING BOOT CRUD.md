# PROJETO SPRING BOOT CRUD

O projeto consiste em uma API rest de um sistema de pedidos com crud de usuário, categoria, produtos e pedidos, implantação na Heroku e testes utilizando o Postman como client da aplicação.



## Requisitos

JDK 11

Sprint Tool Suit 4 ou qualquer IDE de sua preferência

Postman Client

PostgreSQL



## Dependências

- Spring Web
- Spring data JPA
- H2 
- PostgreSQL





## Modelo lógico com padrão em camadas

![](C:\temp\ws-springboot\imagens\modelo-logico-camadas.PNG)

## Modelo de domínio - UML

![](C:\temp\ws-springboot\imagens\modelo-dominio.PNG)



## Configuração do application.properties

*** Abrir o arquivo application.properties em src/main/resources  e colar o conteúdo abaixo ***

```
spring.profiles.active=test

spring.jpa.open-in-view=true
```



## Configuração do application-test.properties

*** Criar o arquivo application-test.proporties em src/main/resources ***

```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## Configuração do application-dev.properties

*** Criar o arquivo application-dev.proporties em src/main/resources ***

```
spring.datasource.url=jdbc:postgresql://localhost:5432/crud-springboot
spring.datasource.username=postgres
spring.datasource.password= sua senha do postgres

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```



## Configuração do application-prod.properties

*** Criar o arquivo application-prod.proporties em src/main/resources ***

```
spring.datasource.url=${DATABASE_URL}
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=false
```



## Requisição Client utilizando o Postman

- Você deve ter instalado no ambiente o app postman.
- Startar o projeto no STS ou na IDE que estiver utilizando

### Consultar produtos

Criar uma Workspace e adicionar uma requisição GET apontando para localhost:8080/products, clicar em Send, resultado esperado:



### Consultar Categorias

Adicionar uma requisição GET apontando para localhost:8080/category, clicar em Send, resultado esperado:
