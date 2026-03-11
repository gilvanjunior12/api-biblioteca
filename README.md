# Biblioteca

Projeto feito para **relembrar os conceitos básicos** de desenvolvimento com Java e Spring Boot.

## O que é

API REST de uma biblioteca: cadastro de livros e usuários, e controle de empréstimos (quem pegou qual livro e data de devolução).

- **Stack:** Spring Boot 3, Java 17, JPA, H2 (em memória), Maven, Lombok
- **Endpoints:** `/books`, `/users`, `/loans`

## Como rodar

1. Na pasta do projeto (onde está o `pom.xml`):
   ```bash
   mvn spring-boot:run
   ```
2. A API sobe na porta **8081** (ou 8080 se alterar o `application.properties`).
3. Exemplos:
   - Livros: http://localhost:8081/books
   - Usuários: http://localhost:8081/users
   - Empréstimos: http://localhost:8081/loans
   - Criar empréstimo: `POST /loans?userId=1&bookId=1`
   - Devolver: `POST /loans/return/{id}`

## Estrutura

- `model` — entidades JPA (Book, User, Loan)
- `repository` — Spring Data JPA
- `service` — regras de negócio
- `controller` — REST
- `config` — DataInitializer (dados iniciais ao subir)
