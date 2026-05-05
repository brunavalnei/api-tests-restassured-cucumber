# 🧪 API Tests - Rest Assured + Cucumber + Allure

Projeto de automação de testes de API utilizando Rest Assured, Cucumber (BDD) e Allure Report, com foco em cenários reais de validação de serviços REST.

## 👩‍💻 Autor

Bruna Valnei

## 🎯 Objetivo

Demonstrar conhecimentos em automação de testes de API utilizando boas práticas de mercado, com estrutura escalável e ferramentas amplamente utilizadas.

## 🛠️ Tecnologias utilizadas

- Java 17
- Maven
- Rest Assured
- Cucumber (BDD)
- JUnit
- Allure Report
- VS Code

## ⚙️ Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

- Java 17+
- Maven 3.9+
- VS Code (ou outra IDE Java)
- Git

## 📦 Extensões recomendadas (VS Code)

- Extension Pack for Java
- Maven for Java
- Cucumber (Gherkin) Full Support

## 📁 Estrutura do projeto

src  
└── test  
    ├── java  
    │    ├── runners  
    │    └── steps  
    └── resources  
        └── features

## 🧪 Cenários implementados

- Buscar usuários (GET)
- Criar usuário (POST)

API utilizada: [https://jsonplaceholder.typicode.com](https://jsonplaceholder.typicode.com)

## ▶️ Como executar os testes

No terminal:mvn clean test

## 📊 Allure Report

### 🔧 Instalação do Allure (Windows)

Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser  
irm get.scoop.sh | iex  
scoop install allure

### ▶️ Gerar e visualizar o relatório

mvn clean test  
allure serve target/allure-results

## 🧠 Conceitos aplicados

- BDD com Cucumber
- Testes de API com Rest Assured
- Validação de status code
- Validação de response body
- Estrutura organizada de testes
- Integração com Allure Report

## 🚀 Próximos passos

- Implementar PUT (atualização)
- Implementar DELETE
- Validação avançada de payload
- Massa de dados dinâmica
- Integração com CI/CD (GitHub Actions)
- Parametrização de ambiente

## 💡 Observações

Projeto estruturado visando boas práticas de mercado, com uso de BDD para facilitar entendimento dos cenários e preparado para evolução em ambientes corporativos.

## 📌 Como clonar o projeto

git clone [https://github.com/SEU-USUARIO/api-tests-restassured-cucumber.git](https://github.com/SEU-USUARIO/api-tests-restassured-cucumber.git)

## ⭐ Contribuição

Este projeto faz parte de estudos e evolução profissional na área de Qualidade de Software.

 
