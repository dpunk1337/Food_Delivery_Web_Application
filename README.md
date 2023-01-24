
# Food Delivery Web Application
 
## About :
- This project was developed as a capstone project for a spring boot course I signed up for. Initially in collaboration. Later individually.

- This project as the name suggests, is a scalable microservices food order and delivery application made for the sole purpose of learning how to implement a microservices based application.

## Functional Features :
- Individual App Dashboards for all stake holders `Buyer`, `Restaurant` and `Delivery Agent`.
- Buyer 
  - Is able to sign-up and login.
  - Is able to lookup restaurants in their city and order from them.
- Restaurant
  - Is able to login in to their account.
  - Is able to Edit their food menu by adding, removing, editing their dishes.
  - Is able to see the current orders, see the delivery agent assigned and mark the orders as given to Delivery Agent when it is picked up.
- Delivery Agent
  - Is able to login in to their account.
  - Is able to see the orders that have been placed, and have access to address of both parties to help them pickup and deliver at correct destinations.

## Non Functional Features :
- Implements a Scalable Microservices Based Architecture which utilizes the concepts like 
  - Api Gateway implemented using Netflix Zuul Spring dependencies.
  - Service Discovery implemented using Netflix Eureka Spring dependencies.
  - Ribbon Load balancer implemented using Netflix Ribbon dependencies.
- Below is the architecture diagram, which has been employed in this project.
  - <img src="https://drive.google.com/uc?export=view&id=1xJ_8WdgO5YGNSFkgVhyaExokcMPvWJ2U" style="width:70%; height:70%" />
- For ease of use, it has been made docker compatible.

## Local Deployment :

### Easy Fixed Deployment ( without the need of any other environment setup ) :
- Pre-requisites
  - Docker Setup
- https://drive.google.com/file/d/1Lkk8Mkw9XjjzL9nbq-MOCX5RyzOXEIrb/view?usp=share_link
- Click on the above link and download the already built project zip.
- Extract it.
- Run docker command below.
  - `docker-compose up --build` from the project directory.

### Normal Deployment :
- Pre-requisites
  - Docker Setup
  - Java JDK 1.8 setup
  - Java JDK 11 setup
  - Maven 3.5+ setup
- Download or clone the project.
- Build all the modules except Zuul-Gateway using maven command below. Make sure it uses JDK 1.8 for build.
  - `mvn package spring-boot:repackage -DskipTests`
- Build the module Zuul-Gateway using maven command below. Make sure it uses JDK 11 for build.
  - `mvn package`
- Run docker command below.
  - `docker-compose up --build` from the project directory.

### How to use :
- For Login and other persistent details check the `MySqlDatabase/init.sql` file
- Login with a Buyer account, see the restaurants, click on one, set the quantity from menu and place order.
- Login with the Restaurant account, see the orders, in that get the mobile number of Delivery Agent.
- Use the above mobile number to get the credentials and login with Delivery Agent account.
- Click on mark order is taken link in Restaurant portal for the particular order.
- The status change will reflect on all three portals, after clicking on refresh.
- Click on mark order is received link in Buyer portal for the particular order.
- The status change will reflect again on all three portals on clicking refresh button.
- Don't forget to explore other side features too.


