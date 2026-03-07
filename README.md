Spring Boot Task Manager API (JWT Authentication)

A secure REST API built using Spring Boot, Spring Security, and JWT Authentication for managing tasks.

Features

User Registration & Login

JWT Authentication

Password Encryption (BCrypt)

Role Based Access Control (ADMIN / USER)

Task CRUD Operations

Secure REST APIs

Layered Architecture

Tech Stack

Java

Spring Boot

Spring Security

JWT

Spring Data JPA

MySQL

Maven

API Endpoints
Authentication

POST /api/auth/register
POST /api/auth/login

Task APIs

GET /tasks
POST /tasks
PUT /tasks/{id}
DELETE /tasks/{id}

Admin APIs

GET /api/admin/tasks
DELETE /api/admin/tasks/{id}

How to Run

Clone the repository

git clone https://github.com/Santoshterani/task-manager-springboot-jwt.git

Open in IntelliJ / Eclipse

Configure database in application.properties

Run the project

Test APIs using Postman

JWT Authentication

After login, include token in header:

Authorization: Bearer
