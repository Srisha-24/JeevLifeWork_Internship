# Employee Management System (Spring Boot + Spring Security)

A basic RESTful Employee Management System that demonstrates:
- User authentication with Spring Security
- Role-based access control (ADMIN & USER)
- Secure endpoints using HTTP Basic Auth
- Password hashing with BCrypt
- Optional: JWT-based authentication

 Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Security
- Spring Data JPA
- H2 Database (can switch to MySQL)
- Maven
- Postman for testing

 Features

 Authentication & Authorization
- Basic Authentication using Spring Security
- BCrypt password encoding
- Two roles:
  - `ADMIN`: Full CRUD access to employees
  - `USER`: Read-only access to profile

 Endpoints

| Method | Endpoint              | Access Role | Description              |
|--------|-----------------------|-------------|--------------------------|
| GET    | `/api/employees`      | ADMIN       | View all employees       |
| POST   | `/api/employees`      | ADMIN       | Create new employee      |
| GET    | `/api/profile`        | USER, ADMIN | View user profile info   |

