FROM openjdk:8-jdk-alpine
# FROM amazoncorretto:8-alpine-jdk
MAINTAINER deepank.puri
COPY target/DeliveryAgentFrontend-0.0.1-SNAPSHOT.war delivery-agent-frontend-0.0.1.war
ENTRYPOINT ["java","-jar","/delivery-agent-frontend-0.0.1.war"]