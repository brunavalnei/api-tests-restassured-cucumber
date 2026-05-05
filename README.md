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

### ▶️ Executar testes (cria o container)

```bash
docker run --name api-tests-container api-tests
```

---

### 📦 Copiar relatório gerado para a máquina

```bash
docker cp api-tests-container:/app/target ./target
```

---

### 🧹 Remover container (opcional, mas recomendado)

```bash
docker rm api-tests-container
```

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
* O relatório é gerado dentro do container e copiado para a máquina com `docker cp`
* Essa abordagem evita problemas de volume no Windows (principalmente com drive `D:`)
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
## ⚙️ Executando via GitHub Actions

O projeto possui uma pipeline no GitHub Actions que executa os testes automaticamente utilizando Docker e gera o relatório Allure como artefato.

### 🚀 Quando a pipeline é executada

A pipeline é executada em dois cenários:

- Ao fazer push na branch `main`
- Manualmente pela aba `Actions`, usando a opção `Run workflow`

### 🔄 Fluxo da pipeline

A esteira realiza os seguintes passos:

1. Baixa o código do repositório
2. Realiza o build da imagem Docker
3. Executa os testes dentro do container
4. Gera o relatório Allure
5. Copia os artefatos gerados
6. Disponibiliza o relatório como artifact no GitHub Actions

### 📦 Baixar o relatório gerado

Após a execução da pipeline:

1. Acesse a aba `Actions` no GitHub
2. Abra a execução da pipeline
3. Vá até a seção `Artifacts`
4. Baixe o arquivo `allure-report`
5. Extraia o `.zip` em uma pasta local

### 🌐 Visualizar o relatório Allure

> ⚠️ Não é recomendado abrir o `index.html` diretamente, pois o relatório pode ficar carregando indefinidamente.

Após extrair o artifact, abra o terminal dentro da pasta onde está o `index.html` e execute:

```bash
npx http-server .

## 💡 Observações

Projeto estruturado visando boas práticas de mercado, com uso de BDD para facilitar entendimento dos cenários e preparado para evolução em ambientes corporativos.

## 📌 Como clonar o projeto

git clone https://github.com/brunavalnei/api-tests-restassured-cucumber.git

## ⭐ Contribuição

Este projeto faz parte de estudos e evolução profissional na área de Qualidade de Software.

 
