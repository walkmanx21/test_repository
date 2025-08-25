FROM openjdk:26-jdk-oracle
LABEL authors="walkm"

WORKDIR /app

COPY build/libs/docker-compose-starter-1.0-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "docker-compose-starter-1.0-SNAPSHOT.jar"]