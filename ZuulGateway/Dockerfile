# FROM maven:3.6.0-jdk-11-slim AS build
# COPY src /home/app/src
# COPY pom.xml /home/app
# RUN mvn -f /home/app/pom.xml package spring-boot:repackage -DskipTests

# FROM openjdk:11-jdk-alpine
FROM amazoncorretto:11-alpine-jdk
MAINTAINER deepank.puri
# COPY --from=build /home/app/target/ZuulGateway-0.0.1-SNAPSHOT.jar zuul-gateway-0.0.1.jar
COPY target/ZuulGateway-0.0.1-SNAPSHOT.jar zuul-gateway-0.0.1.jar
ENTRYPOINT ["java","-jar","/zuul-gateway-0.0.1.jar"]