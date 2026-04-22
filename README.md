# AJ Course Learning - Submission Repo

This repository is my submission for the Udemy AJ course learning. It contains five small Java projects covering JSP, JDBC, Servlets, Hibernate, and Spring Boot.

## Projects Overview

### JSP - Pages and Basic Servlet

**Tech description:** JSP is a server-side view technology that mixes HTML with JSP tags and Java-based components. JSPs are compiled into servlets by the container.

**Flow / working:**

1. The container loads `test_include.jsp` as the welcome page.
2. JSP uses `demo.User` via `jsp:useBean` to show bean usage in views.
3. Other pages are accessible directly (for example: `home.jsp`, `aboutus.jsp`, `contact.jsp`, `menu.jsp`).
4. `/test` hits `TestServlet`, which returns a simple HTML response.

**How to run:**

1. Build:

   mvn clean package

2. Deploy `target/MYJSP.war` to Tomcat.
3. Open:
   - `http://localhost:8080/MYJSP/`
   - `http://localhost:8080/MYJSP/test`

---

### JDBC - Student Data Retrieval

**Tech description:** JDBC is the standard Java API for connecting to relational databases using connections, statements, and result sets.

**Flow / working:**

1. `RetrieveData` opens a MySQL connection via `DriverManager`.
2. A SQL query (`SELECT * FROM students`) runs via `Statement`.
3. Results are read from the `ResultSet` and printed to the console.

**How to run:**

1. Update DB settings in `src/main/java/org/example/RetrieveData.java`.
2. Ensure the DB and `students` table exist.
3. Run:

   mvn -q -Dexec.mainClass=org.example.RetrieveData -Dexec.classpathScope=runtime org.codehaus.mojo:exec-maven-plugin:3.1.0:java

---

### Servlet Projects

**Tech description:** Servlets handle HTTP requests and responses on the server. Combined with JSP and JDBC, they form classic Java web apps.

#### EXP4_SERVLET (CV Form + JDBC)

**Flow / working:**

1. `index.jsp` links to `CV.jsp`.
2. The form posts to `/ConServlet`.
3. `ConServlet` reads parameters and calls `DBTransaction.InsertData(...)`.
4. Data is inserted into `cv.cv_data` and a success message is returned.

**How to run:**

1. Update DB credentials in `EXP4_SERVLET/src/main/java/com/exp4/DBTransaction.java`.
2. Create DB `cv` and table `cv_data` with columns: `name`, `email`, `phone`, `address`, `gender`, `qualification`, `skills`.
3. Build and deploy:

   mvn clean package

4. Deploy `EXP4_SERVLET/target/EXP4_SERVLET.war` to Tomcat.
5. Open `http://localhost:8080/EXP4_SERVLET/`.

#### JDBC-SERVLET (Student CRUD)

**Flow / working:**

1. `index.jsp` redirects to `/home`.
2. `HomeServlet` queries the DB and forwards data to `Home.jsp`.
3. `Insert.jsp` posts to `/insert` to add a student.
4. `Update.jsp` loads the record, then posts to `/update`.
5. `DeleteDetails` deletes by id and redirects back to `/home`.

**How to run:**

1. Update DB credentials in `JDBC-SERVLET/src/main/java/com.operations/DbUtil.java`.
2. Create DB `studentdb` and table `students` with columns: `id`, `name`, `email`, `phone`.
3. Build and deploy:

   mvn clean package

4. Deploy `JDBC-SERVLET/target/JDBC-SERVLET.war` to Tomcat.
5. Open `http://localhost:8080/JDBC-SERVLET/`.

---

### Hibernate - Library Management (Servlet + JSP)

**Tech description:** Hibernate is an ORM framework that maps Java classes to database tables and manages sessions/transactions to reduce JDBC boilerplate.

**Flow / working:**

1. Browser hits `/books`.
2. `ListBooksServlet` loads data using `BookDAO` and forwards to `index.jsp`.
3. The form on `index.jsp` posts to `/book` with `action=create|update|delete`.
4. `BookServlet` calls `BookDAO`, which uses Hibernate to persist changes.

**How to run:**

1. Create MySQL DB `library_db`.
2. Update DB credentials in `src/main/resources/hibernate.cfg.xml`.
3. Build:

   mvn clean package

4. Deploy `target/TakeHomeExam-4-Hibernate.war` to Tomcat.
5. Open `http://localhost:8080/TakeHomeExam-4-Hibernate/books`.

---

### Spring Boot - Student API

**Tech description:** Spring Boot auto-configures Spring apps and provides an embedded server. Spring Data JPA adds repository abstractions. H2 is used for runtime storage.

**Flow / working:**

1. `StudentApiApplication` starts the app.
2. `StudentController` exposes `/students` endpoints.
3. `StudentService` handles logic and calls `StudentRepository`.
4. `StudentRepository` uses JPA to store and query `Student` entities in H2.

**How to run:**

1. Run:

   mvn spring-boot:run

2. Test endpoints:
   - `GET http://localhost:8080/students`
   - `POST http://localhost:8080/students`
   - `GET http://localhost:8080/students/search?name=...`

Optional:

mvn -DskipTests package
java -jar target/TASK5-1.0-SNAPSHOT.war
