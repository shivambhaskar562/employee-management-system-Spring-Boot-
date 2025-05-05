# 🛠️ EMS Backend - CRUD Application

This is a **basic CRUD (Create, Read, Update, Delete)** backend application built for **learning purposes** using:

- **Java**
- **Spring Boot**
- **Hibernate / JPA**
- **SQL & HQL**
- **Maven**

---

## 📚 About

This project is designed to help beginners understand how to:

- Build a RESTful API using Spring Boot
- Use JPA & Hibernate to connect and interact with databases
- Perform CRUD operations on entity data
- Write HQL (Hibernate Query Language) queries
- Manage dependencies using Maven

---

## 🧰 Tech Stack

| Technology | Purpose                     |
|------------|-----------------------------|
| Java       | Backend Programming Language |
| Spring Boot| REST API Framework           |
| JPA/Hibernate | ORM for DB interaction   |
| SQL/HQL    | Query Language               |
| Maven      | Build & Dependency Tool      |

---

## 🏗️ Project Structure

## 📁 Project Structure

```bash
ems-backend/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── ems/
│       │               ├── controller/
│       │               ├── entity/
│       │               ├── repository/
│       │               ├── service/
│       │               └── EmsBackendApplication.java
│       └── resources/
│           ├── application.properties
│           └── other resource files
├── pom.xml                # Maven configuration file
├── mvnw                   # Maven wrapper script (Unix)
├── mvnw.cmd               # Maven wrapper script (Windows)
└── README.md              # Project documentation



2. ## 🏗️ Configure Database
Edit application.properties file:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update




| Method | Endpoint              | Description        |
| ------ | --------------------- | ------------------ |
| GET    | `/api/employees`      | Get all employees  |
| POST   | `/api/employees`      | Create an employee |
| PUT    | `/api/employees/{id}` | Update employee    |
| DELETE | `/api/employees/{id}` | Delete employee    |
