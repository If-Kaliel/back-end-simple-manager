# --- ETAPA 1: BUILD ---
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# --- ETAPA 2: EXECUÇÃO ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia toda a pasta gerada pelo Quarkus para o diretório atual
COPY --from=build /app/target/quarkus-app/ .

# Expõe a porta
EXPOSE 8080

# Comando para iniciar
# O quarkus-run.jar sabe onde procurar a pasta 'lib' automaticamente
CMD ["java", "-jar", "quarkus-run.jar"]