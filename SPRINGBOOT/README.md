# Spring Boot - Student API

This project is part of my Udemy AJ course learning submission.

## Tech description

Spring Boot simplifies building Java applications by auto-configuring Spring components and providing an embedded server. Spring Data JPA adds repository abstractions for database access. This project uses H2 as an in-memory database at runtime.

## What I built

- A REST API for students with endpoints to list, add, and search.
- A layered structure: controller -> service -> repository -> JPA entity.

## Flow / working

1. `StudentApiApplication` starts the Spring Boot app.
2. `StudentController` exposes REST endpoints under `/students`.
3. `StudentService` handles business logic and calls `StudentRepository`.
4. `StudentRepository` uses JPA to store and query `Student` entities in H2.

## How to run

1. From this folder, run:

   mvn spring-boot:run

2. Test endpoints:
   - `GET http://localhost:8080/students`
   - `POST http://localhost:8080/students` (JSON body with `name` and `email`)
   - `GET http://localhost:8080/students/search?name=...`

Optional: build and run the WAR

mvn -DskipTests package
java -jar target/TASK5-1.0-SNAPSHOT.war
