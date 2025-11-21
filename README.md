# 🌍 Global Solution 2025 – Plataforma de Upskilling / Reskilling para o Futuro do Trabalho

API RESTful em **Java + Spring Boot** que simula uma plataforma de **Upskilling/Reskilling** focada em preparar profissionais para o **futuro do trabalho (2030+)**.

A solução permite:

- cadastrar usuários (profissionais/alunos);
- cadastrar trilhas de aprendizagem alinhadas a competências do futuro;
- cadastrar competências (técnicas e humanas);
- matricular usuários em trilhas, acompanhando o status da matrícula.

## 👥 Integrantes do Grupo

- **Arthur Fellipe Estevão da Silva** – RM553320
- **Eduardo Pires Escudero** – RM556527
- **Leonardo Munhoz Prado** – RM556824

## 🎯 Conexão com o tema e ODS

Este projeto está alinhado com:

- **ODS 4 – Educação de Qualidade**
- **ODS 8 – Trabalho decente e crescimento econômico**
- **ODS 9 – Indústria, inovação e infraestrutura**
- **ODS 10 – Redução das desigualdades**

## 🧱 Tecnologias

- Java 17
- Spring Boot 3.5.8
- Spring Web
- Spring Data JPA
- Bean Validation
- H2 Database
- Lombok
- Springdoc OpenAPI

## ⚙️ Como executar

```bash
mvn clean install
mvn spring-boot:run
```

Aplicação: `http://localhost:8080`  
H2 Console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:globalsolutiondb`)

