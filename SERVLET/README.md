# Servlet Projects

This project set is part of my Udemy AJ course learning submission.

## Tech description

Servlets handle HTTP requests and responses on the server. Combined with JSP for views and JDBC for data access, they form classic Java web apps.

## EXP4_SERVLET (CV Form + JDBC)

### What I built

- A CV form (`CV.jsp`) that collects user details.
- A servlet (`ConServlet`) that reads form data and inserts it into MySQL using `DBTransaction`.

### Flow / working

1. `index.jsp` links to the CV form.
2. The form posts to `/ConServlet`.
3. `ConServlet` reads parameters and calls `DBTransaction.InsertData(...)`.
4. Data is inserted into the `cv.cv_data` table and a success message is returned.

### How to run

1. Update DB credentials in `EXP4_SERVLET/src/main/java/com/exp4/DBTransaction.java`.
2. Create a MySQL database `cv` and table `cv_data` with columns: `name`, `email`, `phone`, `address`, `gender`, `qualification`, `skills`.
3. Build and deploy:

   mvn clean package

4. Deploy `EXP4_SERVLET/target/EXP4_SERVLET.war` to Tomcat.
5. Open `http://localhost:8080/EXP4_SERVLET/`.

## JDBC-SERVLET (Student CRUD)

### What I built

- A student management web app using JSP + Servlets + JDBC.
- Servlets for list (`/home`), insert (`/insert`), update (`/update`), and delete (`/delete`).

### Flow / working

1. `index.jsp` redirects to `/home`.
2. `HomeServlet` queries the DB and forwards data to `Home.jsp`.
3. `Insert.jsp` posts to `/insert` to add a student.
4. `Update.jsp` loads the record, then posts to `/update`.
5. `DeleteDetails` deletes by id and redirects back to `/home`.

### How to run

1. Update DB credentials in `JDBC-SERVLET/src/main/java/com.operations/DbUtil.java`.
2. Create a MySQL database `studentdb` and table `students` with columns: `id`, `name`, `email`, `phone`.
3. Build and deploy:

   mvn clean package

4. Deploy `JDBC-SERVLET/target/JDBC-SERVLET.war` to Tomcat.
5. Open `http://localhost:8080/JDBC-SERVLET/`.
