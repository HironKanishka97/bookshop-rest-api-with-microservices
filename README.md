# Rani-Bookshop - REST API with Microservices Architecture

<img src="https://github.com/user-attachments/assets/ee426881-3e52-472e-86d2-1d5c7f90d9e5" width="200"/>

**Rani-Bookshop** is an ongoing project aimed at creating a highly scalable and modular **Spring Boot** REST API with a **Microservices Architecture** for an online bookshop platform. 
The goal of this project is to divide the platform into separate microservices, each responsible for a different part of the system, which work together to deliver a cohesive solution.

## Microservices Overview

### 1. **Book Service**
   The **Book Service** is responsible for managing the collection of books and their categories. 

### 2. **Customer Service**
   The **Customer Service** microservice handles customer-related functionality. It manages the lifecycle of customer information

### 3. **Order Service**
   The **Order Service** is responsible for managing customer orders. It processes book purchases and tracks order details.

### 4. **Service Registry (Eureka)**
   The **Service Registry** is a critical component in the microservices architecture.
   It stores the locations of all running microservices, allowing them to discover and communicate with one another dynamically.
   This central registry uses **Eureka**, enabling microservices to:
   
   - Register themselves on startup.
   - Discover other services' network locations without hardcoding them.
   - Automatically handle load balancing and failover strategies.

### 5. **API Gateway**
   The **API Gateway** acts as a single entry point for all client requests, routing them to the appropriate microservices. It provides:
   
   - Routing: Directs client requests to the appropriate service (e.g., Book Service, Customer Service, etc.).
   - Load Balancing: Distributes incoming requests evenly among instances of services.
   - Security: Implements centralized security features like authentication and authorization for all services.
   - Monitoring: Tracks request metrics, logs, and errors.

## Features Implemented (so far)
- **Book Management**: Some CRUD operations for books and categories.
- **Customer Management**: Some CRUD operations for managing customer profiles.
- **Order Processing**: Some CRUD operations for manage orders.
- **Service Discovery**: Services register and discover each other using Eureka.
- **Centralized API Gateway**: All requests pass through the gateway, which directs them to the appropriate microservices.

## Technologies and Tools
- **Spring Boot**: For building individual microservices.
- **Spring Cloud Netflix Eureka**: For service discovery.
- **Spring Cloud Gateway**: For routing and load balancing.
- **Hibernate**: ORM tool for data persistence.
- **MySQL**: Database for storing application data.
- **Lombok**: Reduces boilerplate code for entity and DTO classes.

## Future Roadmap
1. Completion the CRUD operations of current microservices
2. **Payment Service**: Implement a payment microservice to handle order payments.
3. **Notification Service**: Build a service for sending order confirmation emails or SMS.
4. **Authentication and Authorization**.

## Eureka Server Preview
![image](https://github.com/user-attachments/assets/21283fb8-b6b4-4f5b-ade6-813519942b6b)

### 6\. **License**

This project is licensed under the MIT License - see the LICENSE file for details.

## Authors

👤 **Hiron Kanishka**

- GitHub: [@hironkanishka](https://linkedin.com/in/hiron-kanishka)
- LinkedIn: [Hiron Kanishka](https://www.linkedin.com/in/hiron-kanishka/)

## Feedback and Contributions

If you have any feedback, suggestions, or would like to contribute to this project, your involvement is highly valued. Feel free to open an issue or submit a pull request with your ideas and enhancements. Remember, this template is a starting point, and the true magic lies in making it your own. Enjoy the journey of creating a stunning portfolio that represents your unique talents and accomplishments!

Happy coding and showcasing!

## Show your support

Give a ⭐️ if you like this project!

