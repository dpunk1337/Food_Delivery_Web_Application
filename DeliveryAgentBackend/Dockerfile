FROM openjdk:8-jdk-alpine
# FROM amazoncorretto:8-alpine-jdk
MAINTAINER deepank.puri
COPY target/DeliveryAgentBackend-0.0.1-SNAPSHOT.jar delivery-agent-backend-0.0.1.jar
ENTRYPOINT ["java","-jar","/delivery-agent-backend-0.0.1.jar"]