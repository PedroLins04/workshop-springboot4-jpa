# Workshop Spring Boot 4 + JPA

## Sobre o projeto

Desenvolvido como parte do meu aprendizado em back-end, este projeto simula um sistema de pedidos com usuários, produtos, categorias e itens de pedido.
O objetivo foi colocar em prática os principais conceitos do ecossistema Spring Boot em conjunto com persistência de dados via JPA.

## Tecnologias utilizadas

- Java 25 
- Spring Boot 4.0.6
- Spring Web MVC
- Spring Data JPA
- Hibernate
- Banco H2 (testes)
- PostgreSQL (produção)
- Maven

## Modelo de domínio
User ──< Order ──< OrderItem >── Product >── Category

- **User** - possui vários pedidos
- **Order** - pertence a um usuário, possui vários itens e um pagamento
- **OrderItem** - associa pedido e produto com quantidade e preço
- **Product** - pertence a uma ou mais categorias
- **Category** - agrupa produtos

## Como executar

### Pré-requisitos

- Java 25+
- Maven 3.8+
- PostgreSQL (para produção)

### Clonar o repositório

bash:
git clone https://github.com/PedroLins04/workshop-springboot4-jpa.git
cd workshop-springboot4-jpa

### Executar com perfil de teste (Console H2)

Acesse:
```text
http://localhost:8080/h2-console
```

Credenciais padrão:

| Campo | Valor |
|---------------|
| JDBC URL | `jdbc:h2:mem:testdb` |
| User Name | `sa` |
| Password | *(vazio)* 

### Executar com PostgreSQL
 
1. Crie um banco no PostgreSQL
   sql:
   CREATE DATABASE springboot_course;
   
 
2. Configure as credenciais em src/main/resources/application-dev.properties
   properties:
   jdbc:postgresql://localhost:5432/springboot_course
   spring.datasource.username= postgres
   spring.datasource.password= 1234567
 
3. Suba com o perfil dev
   bash:
   ./mvnw spring-boot:run -Dspring-boot.run.profiles=dev

## Aprendizados

Durante o desenvolvimento deste projeto, pratiquei:

- Construção de APIs REST
- Relacionamentos com JPA/Hibernate
- Arquitetura em camadas
- Persistência de dados
- Perfis de ambiente com Spring
- Integração com PostgreSQL

## Autor

Pedro Lins

- GitHub: https://github.com/PedroLins04
 

   
 






