# Usa a imagem oficial do Java (Eclipse Temurin) versão 21
FROM eclipse-temurin:21-jdk-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia TODOS os arquivos do projeto para o diretório atual do container
COPY . .

# Dá permissão de execução ao Maven Wrapper
# IMPORTANTE: Garanta que o arquivo 'mvnw' esteja na raiz do seu projeto
RUN chmod +x mvnw

# Faz o build do projeto com Maven
# -DskipTests → ignora testes para acelerar
RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install

# Comando para iniciar a aplicação Quarkus
CMD ["sh", "-c", "java -jar target/quarkus-app/quarkus-run.jar"]