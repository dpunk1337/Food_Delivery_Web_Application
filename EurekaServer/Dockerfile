FROM openjdk:8-jdk-alpine
# FROM amazoncorretto:8-alpine-jdk
MAINTAINER deepank.puri
COPY target/EurekaServer-0.0.1-SNAPSHOT.jar eureka-server-0.0.1.jar
ENTRYPOINT ["java","-jar","/eureka-server-0.0.1.jar"]