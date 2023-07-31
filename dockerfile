FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

# Comando para executar o aplicativo Spring Boot
CMD ["java", "-war", "target/autorizador-exames-medicos.war"]