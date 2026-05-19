# --- ETAPA 1: BUILD ---
# Usamos uma imagem que JÁ VEM com Maven e Java 21 para compilar seu projeto
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copia tudo para o container
COPY . .

# Compila o projeto sem precisar do mvnw
RUN mvn clean package -DskipTests

# --- ETAPA 2: EXECUÇÃO ---
# Usamos uma imagem leve apenas com o JRE (Java Runtime Environment) para rodar
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia apenas o arquivo .jar gerado na etapa de build
# O Quarkus gera o executável dentro da pasta target/quarkus-app
COPY --from=build /app/target/quarkus-app/quarkus-run.jar ./quarkus-run.jar

# Expõe a porta que o Quarkus usa
EXPOSE 8080

# Comando para iniciar
CMD ["java", "-jar", "quarkus-run.jar"]