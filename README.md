# Gerenciamento de Funcionários

Projeto de exemplo desenvolvido em **Spring Boot** com **Java 21** para gerenciamento de funcionários, cargos e departamentos. Permite criar, atualizar, deletar e consultar funcionários, além de filtrar por departamento e cargo. Utiliza **H2 Database** para persistência durante testes.

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.3
- Spring Data JPA
- H2 Database
- Lombok
- Maven

---

## Estrutura do Projeto

- `model/` → Classes `Funcionario`, `Cargo`, `Departamento`
- `repository/` → Interfaces que estendem `JpaRepository` para persistência
- `service/` → Regras de negócio e métodos CRUD
- `controller/` → Endpoints REST para interação com o frontend ou Postman

---

## Endpoints Disponíveis

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/funcionarios` | Lista todos os funcionários |
| GET | `/funcionarios/{id}` | Busca funcionário por ID |
| POST | `/funcionarios` | Cria um novo funcionário |
| PUT | `/funcionarios/{id}` | Atualiza um funcionário existente |
| DELETE | `/funcionarios/{id}` | Deleta um funcionário |
| GET | `/funcionarios/departamento/{id}` | Filtra funcionários por departamento |
| GET | `/funcionarios/cargo/{id}` | Filtra funcionários por cargo |

---

## Configuração do H2 Database

No arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
