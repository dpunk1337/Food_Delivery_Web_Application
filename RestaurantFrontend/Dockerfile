FROM openjdk:8-jdk-alpine
# FROM amazoncorretto:8-alpine-jdk
MAINTAINER deepank.puri
COPY target/RestaurantFrontend-0.0.1-SNAPSHOT.war restaurant-frontend-0.0.1.war
ENTRYPOINT ["java","-jar","/restaurant-frontend-0.0.1.war"]