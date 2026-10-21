FROM maven:3.9.16-eclipse-temurin-21

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package

EXPOSE 8081

CMD ["java", "-jar", "target/smartshop-1.0.0.jar"]