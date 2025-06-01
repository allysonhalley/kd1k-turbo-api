# Etapa de construção
FROM openjdk:17-jdk-slim as build
LABEL authors="allysonhalley"
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw clean package -DskipTests

# Etapa de produção
FROM openjdk:17-jdk-slim
WORKDIR /app
VOLUME /tmp

# Copia o fat jar gerado para a imagem final
COPY --from=build /workspace/app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

#FROM openjdk:17-jdk-slim
#VOLUME /tmp
#ARG DEPENDENCY=/workspace/app/target/dependency
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.kd1k.api.Kd1kApiApplication"]