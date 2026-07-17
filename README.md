# 📚 Biblioteca API

API REST desenvolvida com **Spring Boot** para gerenciamento de uma biblioteca.

O projeto foi criado com o objetivo de praticar os principais conceitos de desenvolvimento Back-end utilizando Java e Spring, seguindo boas práticas de arquitetura em camadas.

---

## 🚀 Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- MySQL
- H2 Database
- ModelMapper
- Bean Validation

---

## 📂 Estrutura do Projeto

O projeto segue a arquitetura em camadas:

```
Controller
   ↓
Service
   ↓
Repository
   ↓
Banco de Dados
```

Organização dos pacotes:

```
controllers/
services/
repositories/
models/
dtos/
exceptions/
configs/
profiles/
```

---

## 📖 Funcionalidades

### Categorias

- ✅ Cadastrar categoria
- ✅ Buscar categoria por ID
- ✅ Listar categorias
- ✅ Atualizar categoria
- ✅ Excluir categoria

### Livros

- ✅ Cadastrar livro
- ✅ Buscar livro por ID
- ✅ Listar livros
- ✅ Atualizar livro
- ✅ Excluir livro

---

## 🛠 Boas práticas aplicadas

- Arquitetura em camadas
- Utilização de DTOs
- Separação entre Model e DTO
- Injeção de Dependência
- Tratamento de exceções personalizadas
- Validação de dados
- Uso do ModelMapper para conversão entre entidades e DTOs
- Código comentado para facilitar o entendimento

---

## 💾 Banco de Dados

O projeto pode utilizar:

- H2 Database (desenvolvimento)
- MySQL

---

## ▶️ Como executar

Clone o projeto

```bash
git clone https://github.com/norbertodavid/bibliotecaNoite.git
```

Entre na pasta

```bash
cd bibliotecaNoite
```

Execute

```bash
./mvnw spring-boot:run
```

Ou pela sua IDE favorita (IntelliJ ou Eclipse).

---

## 📌 Objetivo

Este projeto foi desenvolvido como prática durante meus estudos em **Java e Spring Boot**, com foco em compreender a construção de APIs REST utilizando uma arquitetura limpa e organizada. Aprender como criar um **CRUD** bem estruturado.

---

## 👨‍💻 Autor

**Norberto David**

Estudante de Análise e Desenvolvimento de Sistemas - Faculdade UniFatecie

Java • Spring Boot • APIs REST • SQL

GitHub:
https://github.com/norbertodavid

LinkedIn:
https://linkedin.com/in/norberto-david-sp
