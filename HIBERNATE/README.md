# Hibernate - Library Management (Servlet + JSP)

This project is part of my Udemy AJ course learning submission.

## Tech description

Hibernate is an ORM framework that maps Java classes to database tables. It manages sessions and transactions, reduces JDBC boilerplate, and lets you work with objects instead of manual SQL for basic CRUD.

## What I built

- A simple library CRUD app for books using Hibernate, Servlets, and JSP.
- A `Book` entity mapped to the `books` table.
- DAO-based persistence with Hibernate sessions and transactions.
- JSP UI for listing, adding, updating, and deleting books.

## Flow / working

1. Browser hits `/books`.
2. `ListBooksServlet` loads data using `BookDAO` and forwards to `index.jsp`.
3. The form on `index.jsp` posts to `/book` with `action=create|update|delete`.
4. `BookServlet` calls `BookDAO`, which uses Hibernate to persist changes.

## How to run

1. Create a MySQL database (default is `library_db`).
2. Update DB credentials in `src/main/resources/hibernate.cfg.xml`.
3. Build the WAR:

   mvn clean package

4. Deploy `target/TakeHomeExam-4-Hibernate.war` to a servlet container (Tomcat).
5. Open:
   - `http://localhost:8080/TakeHomeExam-4-Hibernate/books`
