# =========================
# Build stage
# =========================
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copie d'abord le pom pour profiter du cache Docker
COPY pom.xml .

# Télécharge les dépendances
RUN mvn dependency:go-offline

# Copie le code source
COPY src ./src

# Compile l'application
RUN mvn clean package -DskipTests


# =========================
# Runtime stage
# =========================
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
