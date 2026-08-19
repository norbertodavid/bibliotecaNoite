# Etapa 1: Build da aplicação com Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests -Dfile.encoding=UTF-8

# Etapa 2: Execução com JRE mantida pelo Eclipse Temurin
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
