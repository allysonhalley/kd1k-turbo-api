# Stage 1: Build using Maven image to ensure dependencies are handled correctly
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy the project files
COPY . .

# Build the application skipping tests to speed up
RUN mvn clean package -DskipTests

# Stage 2: Runtime image
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy the built jar from the build stage
# Using wildcard to match any version
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]