FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY ./pom.xml /app
COPY ./src /app/src
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:17-jdk-alpine
WORKDIR /app

# Install PostgreSQL client
RUN apk update && apk add postgresql-client

COPY --from=build /app/target/*.jar app.jar
COPY wait-for-postgres.sh /wait-for-postgres.sh
RUN chmod +x /wait-for-postgres.sh
EXPOSE 8080
ENTRYPOINT ["/wait-for-postgres.sh", "emt-db", "java", "-jar", "app.jar"]
