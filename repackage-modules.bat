call mvn -f BuyerFrontend/pom.xml package spring-boot:repackage -DskipTests
call mvn -f DeliveryAgentFrontend/pom.xml package spring-boot:repackage -DskipTests
call mvn -f RestaurantFrontend/pom.xml package spring-boot:repackage -DskipTests
call mvn -f BuyerBackend/pom.xml package spring-boot:repackage -DskipTests
call mvn -f DeliveryAgentBackend/pom.xml package spring-boot:repackage -DskipTests
call mvn -f RestaurantBackend/pom.xml package spring-boot:repackage -DskipTests
call mvn -f RestaurantBackend/pom.xml package spring-boot:repackage -DskipTests
call mvn -f EurekaServer/pom.xml package spring-boot:repackage -DskipTests
