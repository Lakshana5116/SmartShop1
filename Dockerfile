FROM maven:3.9.16-eclipse-temurin-21

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package

EXPOSE 8081

CMD ["mvn", "org.codehaus.mojo:exec-maven-plugin:3.5.0:java", "-Dexec.mainClass=com.smartshop.SmartShopWebApp"]