
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
