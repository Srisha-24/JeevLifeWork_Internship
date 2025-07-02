 Student Manager (Java 8 + JDBC + MySQL)

 Overview:
A console-based, modular Java application for managing a student list with full CRUD functionality. Uses Java 8 streams, Optional, DAO-Service architecture, JDBC best practices, logging, validation, and CSV export.

 Features:
 Java 8: Lambdas, Optional, Streams
 DAO + Service layer separation
 JDBC with PreparedStatements, try-with-resources
 Validation using regex + exceptions
 Logging via SLF4J + Logback
 DB config in `db.properties`
 CSV export utility
 Easy console UI
 JUnit testing (add tests in `src/test/java`)
  
 Prerequisites:
 Java 8+
 
 MySQL with: sql
  CREATE DATABASE studentdb;
  USE studentdb;
  CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    gpa DECIMAL(3,2)
  );
