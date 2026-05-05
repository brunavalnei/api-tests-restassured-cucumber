FROM maven:3.9.9-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

# Gera testes + relatório Allure no diretório padrão (target)
CMD ["sh", "-c", "mvn clean test && mvn allure:report"]