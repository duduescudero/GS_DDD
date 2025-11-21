# 🌍 Global Solution 2025 – Plataforma de Upskilling / Reskilling para o Futuro do Trabalho

API RESTful desenvolvida em Java 17 + Spring Boot 3, estruturada com princípios de Domain Driven Design (DDD).  
A plataforma simula uma solução moderna de Upskilling e Reskilling, alinhada às necessidades do mercado de trabalho de 2030+ e conectada às ODS da ONU.

---

## 👥 Integrantes do Grupo

- Arthur Fellipe Estevão da Silva – RM553320  
- Eduardo Pires Escudero – RM556527  
- Leonardo Munhoz Prado – RM556824  

---

## 📘 Sumário

- Visão Geral  
- Problema & Solução Proposta  
- Arquitetura do Projeto (DDD)  
- Estrutura de Pastas  
- Modelo de Domínio (UML)  
- Endpoints da API  
- Exemplos JSON  
- Validações Implementadas  
- Tratamento de Erros  
- Configuração do Banco H2  
- Como Executar o Projeto  
- Conexão com ODS  
- Checklist de Requisitos Atendidos  

---

## 🔎 Visão Geral

A plataforma permite:

### 👤 Gestão de Usuários
- Cadastro  
- Atualização  
- Exclusão  
- Listagem  

### 🧭 Trilhas de Aprendizagem
- Competências hard e soft  
- Estruturadas por nível e objetivo  

### 🧩 Competências
- Habilidades técnicas  
- Habilidades comportamentais  

### 🎓 Matrículas
- Associação usuário ↔ trilha  
- Data da inscrição  
- Status da matrícula  

---

## 🧩 Problema & Solução Proposta

### ❗ O Problema
O mercado de 2030 exige:
- Atualização contínua  
- Reskilling em carreiras emergentes  
- Competências humanas e técnicas  
- Adaptação a IA, automação e dados  

### 💡 A Solução
Criamos uma plataforma que:
✔ Gerencia trilhas educacionais  
✔ Mapeia competências  
✔ Registra matrículas  
✔ Acompanha evolução do aluno  
✔ Incentiva aprendizado contínuo  

---

## 🏛 Arquitetura do Projeto (DDD)

Camadas utilizadas:

```
domain/      → Entidades e regras de negócio  
repository/  → Persistência (Spring Data JPA)  
service/     → Lógica e validações  
controller/  → API REST  
exception/   → Tratamento de erros  
```

Benefícios:
- Manutenção facilitada  
- Baixo acoplamento  
- Expansão simples  
- Código organizado  

---

## 📂 Estrutura de Pastas

```
src/main/java/br/com/fiap/globalsolution
│
├── config/                  
├── controller/              
├── exception/               
├── model/                   
├── repository/              
├── service/                 
└── GlobalSolutionApplication.java
```

---

## 🧠 Modelo de Domínio (UML)

```text
+---------------------+        +---------------------+        +----------------------+
|       Usuario       | 1..N   |      Matricula      | N..1   |        Trilha        |
+---------------------+        +---------------------+        +----------------------+
| id                  |        | id                  |        | id                   |
| nome                |        | dataInscricao       |        | nome                 |
| email               |        | status              |        | descricao            |
| areaAtuacao         |        | usuario_id ---------|------> | nivel                |
| nivelCarreira       |        | trilha_id  ---------|------> | cargaHoraria         |
+---------------------+        +---------------------+        +----------------------+
                                                          | 1..N
                                                          |
                                                          v
                                                  +----------------------+
                                                  |     Competencia      |
                                                  +----------------------+
                                                  | id                   |
                                                  | nome                 |
                                                  | descricao            |
                                                  +----------------------+
```

---

## 📡 Endpoints da API

### 👤 Usuários
```
GET    /api/usuarios  
GET    /api/usuarios/{id}  
POST   /api/usuarios  
PUT    /api/usuarios/{id}  
DELETE /api/usuarios/{id}  
```

### 🧭 Trilhas
```
GET    /api/trilhas  
GET    /api/trilhas/{id}  
POST   /api/trilhas  
PUT    /api/trilhas/{id}  
DELETE /api/trilhas/{id}  
```

### 🧩 Competências
```
GET    /api/competencias  
POST   /api/competencias  
```

### 🎓 Matrículas
```
GET  /api/matriculas  
GET  /api/matriculas/usuario/{id}  
POST /api/matriculas?usuarioId=1&trilhaId=3  
```

---

## 📦 Exemplos JSON

### Criar usuário
```json
{
  "nome": "Ana Silva",
  "email": "ana.silva@fiap.com",
  "areaAtuacao": "Tecnologia",
  "nivelCarreira": "Júnior"
}
```

### Criar trilha
```json
{
  "nome": "Trilha de Inteligência Artificial",
  "descricao": "Introdução a IA e Machine Learning",
  "nivel": "Intermediário",
  "cargaHoraria": 40,
  "focoPrincipal": "Tecnologia"
}
```

### Criar competência
```json
{
  "nome": "Lógica de Programação",
  "categoria": "Técnica",
  "descricao": "Fundamentos essenciais de programação"
}
```

---

## ✔ Validações Implementadas

- @NotBlank  
- @Email  
- @Min  
- @PastOrPresent  
- @NotNull  

---

## ❌ Tratamento de Erros

- **400** — Erros de validação  
- **404** — Recurso não encontrado  
- **500** — Erro interno  
- Retorno em **JSON estruturado**  

---

## 🗄 Configuração do Banco H2

Console disponível em:  
👉 http://localhost:8080/h2-console

Credenciais:

```
JDBC URL: jdbc:h2:mem:globalsolutiondb
User: sa
Password: (vazio)
```

---

## 🏁 Como Executar o Projeto

### Requisitos
- Java 17  
- Maven 3.8+  

### Comandos
```
mvn clean install
mvn spring-boot:run
```

Aplicação inicia em:  
👉 http://localhost:8080  

---

## 🌱 Conexão com ODS

| ODS | Contribuição |
|-----|--------------|
| **ODS 4**  | Educação de qualidade via trilhas acessíveis |
| **ODS 8**  | Prepara para novas carreiras e crescimento econômico |
| **ODS 9**  | Incentiva inovação e tecnologia |
| **ODS 10** | Reduz desigualdades no acesso à capacitação |

---

## ✅ Checklist de Requisitos Atendidos

| Requisito                    | Status |
|------------------------------|--------|
| 2 CRUDs completos           | ✔ |
| DDD aplicado                | ✔ |
| Validações Bean Validation  | ✔ |
| Seeds no banco              | ✔ |
| Exceções customizadas       | ✔ |
| README completo             | ✔ |
| Arquitetura em camadas      | ✔ |
| Matrículas implementadas     | ✔ |

