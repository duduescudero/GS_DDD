# 🌍 Global Solution 2025 – Plataforma de Upskilling / Reskilling para o Futuro do Trabalho

API RESTful desenvolvida em Java 17 + Spring Boot 3 utilizando os princípios de Domain Driven Design (DDD).
A solução simula uma plataforma moderna de Upskilling e Reskilling, conectada às demandas do futuro do trabalho (2030+), alinhada às ODS das Nações Unidas.

## 👥 Integrantes
Arthur Fellipe Estevão da Silva – RM553320  
Eduardo Pires Escudero – RM556527  
Leonardo Munhoz Prado – RM556824


## 📘 Sumário
- Visão Geral
- Problema & Solução Proposta
- Arquitetura do Projeto (DDD)
- Estrutura de Pastas
- Modelo de Domínio
- Endpoints da API (OpenAPI)
- Validações Aplicadas
- Configuração do Banco H2
- Como Executar o Projeto
- Conexão com ODS

## 🔎 Visão Geral
A plataforma permite:

👤 Gestão de Usuários  
Cadastrar e gerenciar profissionais/alunos com informações como: nome, email, área de atuação, nível de carreira e data de cadastro.

🧭 Trilha de Aprendizagem  
Criar trilhas focadas em competências do futuro (Tech, Human Skills etc).

🧩 Competências  
Cadastro de habilidades técnicas/soft skills que compõem cada trilha.

🎓 Matrículas  
Vincular usuários às trilhas e acompanhar o progresso.

## 🧩 Problema & Solução Proposta  
O mercado de trabalho 2030 exige aprendizado contínuo, adaptação rápida, competências humanas/técnicas e reskilling.  
A solução oferece trilhas educacionais, mapeamento de competências, acompanhamento e personalização.

## 🏛 Arquitetura do Projeto (DDD)
domain/ – Entidades e regras  
repository/ – Persistência  
service/ – Regras de negócio  
controller/ – API REST  
exception/ – Tratamento de erros  

## 📂 Estrutura de Pastas
src/main/java/br/com/fiap/globalsolution  
config/ | controller/ | exception/ | model/ | repository/ | service/

## 🧠 Modelo de Domínio
Usuário | Competência | Trilha | Matrícula  
Relacionamentos:  
Usuário 1..N Matrículas | Trilha 1..N Matrículas | Trilha N..N Competências

## 📡 Endpoints (Swagger)
http://localhost:8080/swagger-ui/index.html

## ✔ Validações Aplicadas
Bean Validation (@NotBlank, @Email, @PastOrPresent)

## ❌ Tratamento de Erros
404 | 400 | 409

##🗄 Banco H2
Console: http://localhost:8080/h2-console  
JDBC: jdbc:h2:mem:globalsolutiondb

##🏁 Como Executar
mvn clean install  
mvn spring-boot:run

##🌱 Conexão com ODS
ODS 4, 8, 9, 10 — conforme descrição do projeto.

