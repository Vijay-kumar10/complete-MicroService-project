
# Hotel Rating Microservices Project

## 📌 About the Project

This project demonstrates a microservices architecture where three independent services are created and managed through a centralized API Gateway and Service Registry.

User Service 👤 → Manages user-related operations

Hotel Service 🏨 → Handles hotel information and management

Rating Service ⭐ → Stores and retrieves user ratings for hotels

All services communicate with each other using REST APIs, discovered dynamically via Eureka Server. Configuration is managed centrally and fetched from a GitHub-hosted Config Server.

## ⚙️ Features

✅ Spring Boot Microservices (User, Hotel, Rating)

✅ API Gateway for centralized routing

✅ Eureka Server & Clients for service discovery

✅ Config Server with externalized configuration (GitHub as config repo)

✅ Inter-service communication using REST APIs

✅ Scalable & maintainable architecture

## 🛠️ Tech Stack Used

🛠️ Tech Stack

✅ Backend: Spring Boot (Microservices)

✅ API Gateway: Spring Cloud Gateway

✅ Service Registry: Eureka Server

✅ Config Management: Spring Cloud Config + GitHub

✅ Database: MySQL (for persistent storage)

✅ Security: Spring Security + JWT (optional, if implemented)

✅ Version Control: Git & GitHub
## 📂 Project Structure

hotel-rating-microservices/  
│── user-service/        # User microservice  
│── hotel-service/       # Hotel microservice  
│── rating-service/      # Rating microservice  
│── api-gateway/         # Centralized gateway  
│── service-registry/    # Eureka server  
│── config-server/       # Centralized config server (fetching from GitHub)

## Contact / Author Info
👤 Developed by [Vijay Kumar](https://github.com/Vijay-kumar10)
📧 Email: kumar888985@gmail.com
