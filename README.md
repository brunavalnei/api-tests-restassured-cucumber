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

## 🐳 Executando com Docker

### 🔧 Build da imagem

```bash
docker build -t api-tests .
```

---

### ▶️ Executar testes e gerar relatório

```bash
docker run -v ${PWD}/target:/app/target api-tests
```

> 💡 No Windows (Prompt de Comando), use:
>
> ```bash
> docker run -v %cd%/target:/app/target api-tests
> ```

---

### 📊 Local do relatório gerado

```text
target/site/allure-maven-plugin/index.html
```

---

### 🌐 Visualizar o relatório corretamente

> ⚠️ Evite abrir o HTML diretamente (pode ficar em loading infinito)

```bash
npx http-server target/site/allure-maven-plugin
```

Acesse no navegador:

```text
http://localhost:8080
```

---

## 💡 Observações

* O container executa os testes (`mvn clean test`) e gera o relatório (`mvn allure:report`)
* O volume (`-v`) salva o relatório na máquina local
* Todos os artefatos ficam na pasta `target/`
* Não é necessário instalar o Allure CLI

---

## 🐳 Dockerfile utilizado

```dockerfile
FROM maven:3.9.9-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

CMD ["sh", "-c", "mvn clean test && mvn allure:report"]
```


## 💡 Observações

Projeto estruturado visando boas práticas de mercado, com uso de BDD para facilitar entendimento dos cenários e preparado para evolução em ambientes corporativos.

## 📌 Como clonar o projeto

git clone https://github.com/brunavalnei/api-tests-restassured-cucumber.git

## ⭐ Contribuição

Este projeto faz parte de estudos e evolução profissional na área de Qualidade de Software.

 
