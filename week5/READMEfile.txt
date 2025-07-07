
 Features

Create, Read, Update, Delete Students

Input validation using javax.validation

Custom exceptions with @ControllerAdvice

MySQL database integration

Swagger UI documentation

Unit testing with JUnit and Mockito

Uses Lombok to reduce boilerplate code


*Technologies Used

Java 17

Spring Boot

Spring Data JPA

MySQL

Lombok

Swagger (Springdoc OpenAPI)

JUnit & Mockito

Testcontainers (optional)



* API Endpoints

Method

Endpoint

Description

POST

/students

Add new student

GET

/students

Get all students

GET

/students/{id}

Get student by ID

PUT

/students/{id}

Update student

DELETE

/students/{id}

Delete student

 API Docs (Swagger UI)

Visit:

http://localhost:8080/swagger-ui/index.html

 Testing

Unit tests for the service layer are available under:

src/test/java/com/example/studentcrud/service/StudentServiceTest.java

Run using:

./mvnw test

 Error Handling Example

Validation Error:

{
  "age": "Age must be positive"
}

404 Not Found:

"Student not found with id 99"

 