
# 🌊 Ocean Hazard Intelligence Platform – Backend Service

This repository contains the backend for the **Ocean Hazard Intelligence Platform**, developed using **Spring Boot**, **MySQL**, **JWT Authentication**, and **Gradle**.  
The backend provides secure APIs, user authentication, database services, and scheduled background jobs.

---

## 🚀 Project Overview

The backend currently supports:
- 🔐 **User Login with JWT Authentication**
- 🔒 **Password hashing using BCrypt**
- 🛡️ **Spring Security protection for routes**
- 🗄️ **Database integration using MySQL + JPA**
- ⏱️ **Scheduled tasks for future hazard data processing**

This service will act as the core API layer for the main Ocean Hazard Intelligence Platform.

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3 / 4**
- **Spring Security (JWT + PasswordEncoder)**
- **Spring Data JPA**
- **MySQL Database**
- **Gradle (Kotlin DSL)**
- **Spring Scheduler**

---

## 📁 Folder Structure

backend/
└── src/main/java/org/incois/backend

├── config/

├── controller/

├── entity/

├── repository/

├── security/

├── service/

├── tasks/

└── IncoisBackendApplication.java


---

## 🔐 Authentication Workflow

1️⃣ **POST** `/api/auth/login`  
→ Accepts username + password

2️⃣ Backend:
- Fetches user from DB
- Verifies hashed password using BCrypt
- Generates a JWT token

3️⃣ Response:
```json
{
  "token": "your_jwt_token_here"
}
4️⃣ Use token in protected APIs:

makefile
Copy code
Authorization: Bearer <token>
🗄️ MySQL Setup
Create database:

sql
Copy code
CREATE DATABASE incois_db;
Insert a sample user:

sql
Copy code
INSERT INTO users (username, password) VALUES (
  'testuser',
  '$2a$10$6UCa9iSzxqQ6xFMl/UwvO91W1q1fG6t5Vtj8uveajePf...'
);
(The password is hashed for “password123”)

⚙️ Running the Backend
1️⃣ Update DB credentials
In application.properties:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/incois_db
spring.datasource.username=root
spring.datasource.password=yourpassword
2️⃣ Start the project
bash
Copy code
./gradlew bootRun
OR through IntelliJ ➝ Run IncoisBackendApplication

🧪 Testing Login (Postman)
bash
Copy code
POST http://localhost:8080/api/auth/login
Body:

json
Copy code
{
  "username": "testuser",
  "password": "password123"
}
Expected:

200 OK with JWT token ✔️
If wrong password:

401 Unauthorized ❌

⏱️ Background Scheduler
The backend includes a simple scheduler that prints:

Scheduler is working! <timestamp>
This verifies system heartbeat and will later be used for:

Automated hazard analysis

Data ingestion

Alerts

🌿 Branch Workflow
You are working on the development branch:

naveen-backend-fix
Steps You Follow:
  1.Clone the repo
  2.Switch to branch
  3.Make changes
  4.Commit
  5.Push

Create Pull Request

👨‍💻 Developer (Backend)
Naveen Pandey
   -> Handles backend API development
   ->Implements security + JWT
   ->Connects MySQL
   ->Builds controllers, services, repositories
   ->Works on bug fixes under branch: naveen-backend-fix



