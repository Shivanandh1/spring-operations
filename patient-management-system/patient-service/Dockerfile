# Stage 1: Build
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests


# Stage 2: Runtime
FROM eclipse-temurin:21-jdk-jammy AS runtime

WORKDIR /app

# Create a non-root user for security
RUN useradd -m -u 1000 appuser

COPY --from=builder /app/target/patient-service-0.0.1-SNAPSHOT.jar ./app.jar

# Change ownership
RUN chown -R appuser:appuser /app

USER appuser

EXPOSE 4000

ENTRYPOINT ["java", "-jar", "app.jar"]