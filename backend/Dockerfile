# Stage 1: build con Maven
FROM maven:3.9.12-eclipse-temurin-25 AS build
WORKDIR /app

# Copia pom.xml e scarica le dipendenze (cache layer)
COPY pom.xml pom.xml
RUN mvn dependency:go-offline

# Copia il codice sorgente
COPY src src

# Build del jar eseguibile
RUN mvn clean package -DskipTests spring-boot:repackage

# Stage 2: runtime
FROM eclipse-temurin:25-jdk
WORKDIR /app

# Copia il jar eseguibile dallo stage build
COPY --from=build /app/target/*.jar app.jar

# Esponi porta applicazione + porta debug
EXPOSE 8080 5005

# Avvio in modalità debug remoto
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005","-jar","app.jar"]

