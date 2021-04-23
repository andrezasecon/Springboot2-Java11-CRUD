# PROJETO SPRING BOOT CRUD

O projeto consiste em uma API rest de um sistema de pedidos com CRUD de usuário, categoria, produtos e pedidos, implantação na Heroku e testes utilizando o Postman como client da aplicação.

Endereço local: http://localhost:8080/

Endereço de produção Heroku: https://course-nelio-crud-spring-boot.herokuapp.com/



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

![](https://github.com/andrezasecon/Springboot2-Java11-CRUD/tree/master/imagens/modelo-logico-camadas.PNG)

## Modelo de domínio - UML

![](https://github.com/andrezasecon/Springboot2-Java11-CRUD/tree/master/imagens/modelo-dominio.PNG)



## Configuração do application.properties

*** Abrir o arquivo application.properties em src/main/resources  e colar o conteúdo abaixo ***

```
spring.profiles.active=test

spring.jpa.open-in-view=true
```

**active** = test - utiliza o banco H2 em memória

**active** = dev - utiliza o banco de dados postgreSQL local

**active** = prod - utiliza o banco de dados postgreSQL da Heroku



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
spring.datasource.url=${DATABASE_URL} Variável de ambiente configurado na Heroku
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=false
```

- Comentar todos os moks manuais da classe TesConfig
- Criar o arquivo system.properties na raiz do projeto com o conteúdo abaixo para informar a versão do Java para a Heroku

```
java.runtime.version=11
```



## Requisição Client utilizando o POSTMAN

![](https://github.com/andrezasecon/Springboot2-Java11-CRUD/tree/master/imagens/POSTMAN.png)



**AMBIENTE DE TESTES E AMBIENTE DE DESENVOLVIMENTO**

- Ajustar o arquivo application.properties para o ambiente desejado (test ou dev)

- Startar o projeto no STS ou na IDE que estiver utilizando e acessar o link abaixo no browser
- http://localhost:8080 

**AMBIENTE DE PRODUÇÃO**

- Antes de fazer o deploy na Heroku, ajustar o arquivo application.properties para o ambiente  de produção (prod)
- https://course-nelio-crud-spring-boot.herokuapp.com/

### GET - Find All

Status esperado: 200 ok

**/users**

**/products**

**/categories**

**/orders**

![](https://github.com/andrezasecon/Springboot2-Java11-CRUD/tree/master/imagens/findAll.PNG)

### GET - Find by ID

Para buscar o item desejado passar o ID como parâmetro na requisição, Status esperado: 200 ok



**/users/1**

**/products/1**

**/categories/1**

**/orders/1**

![](https://github.com/andrezasecon/Springboot2-Java11-CRUD/tree/master/imagens/findById.PNG)

### POST - Insert User, Product, Category, Order

Para inserir um usuário, colocar no Body, raw, tipo Json, inserir os dados desejados no formato Json, Status esperado: 201 ok

**/users**

**/products**

**/categories**

**/orders**

```
{
    "name": "Andreza Secon",
    "email": "andrezasecon@gmail.com",
    "phone": "942158852",
    "password": "123456" 
} 
```

![](https://github.com/andrezasecon/Springboot2-Java11-CRUD/tree/master/imagens/addITem.PNG)

### PUT - Update User, Product, Category by id

Para atualizar um registro, passar o id desejado na requisição, Status esperado: 200 ok

**/users/1**

**/products/1**

**/categories/1

No Body da requisição clicar em raw, tipo Json e adicionar o campo que deseja alterar no formato Json

```
{     
    "name": "Bob Brown",     
    "email": "bob@gmail.com",     
    "phone": "977557755" 
}
```

![](https://github.com/andrezasecon/Springboot2-Java11-CRUD/tree/master/imagens/updateById.PNG)

### DELETE - Delete Item by ID

Para excluir um item, passar o ID como parâmetro da requisição, Status esperado: 200 ok

**/users/1**

**/products/1**

**/categories/1

![](https://github.com/andrezasecon/Springboot2-Java11-CRUD/tree/master/imagens/deleteItem.PNG)



### 