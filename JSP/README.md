# JSP - Pages and Basic Servlet

This project is part of my Udemy AJ course learning submission.

## Tech description

JSP (JavaServer Pages) is a server-side view technology that mixes HTML with JSP tags and Java-based components. JSPs are compiled into servlets by the container, so you can generate dynamic HTML on the server.

## What I built

- Multiple JSP pages for simple navigation and content examples.
- A welcome page (`test_include.jsp`) that demonstrates `jsp:useBean` with the `demo.User` class.
- A basic servlet (`TestServlet`) mapped to `/test` that writes plain HTML.

## Flow / working

1. The container loads `test_include.jsp` as the welcome page.
2. JSP uses `demo.User` via `jsp:useBean` to show how beans can be used in views.
3. You can access other pages directly (for example: `home.jsp`, `aboutus.jsp`, `contact.jsp`, `menu.jsp`).
4. Hitting `/test` returns a simple servlet response.

## How to run

1. Build the WAR:

   mvn clean package

2. Deploy `target/MYJSP.war` to a servlet container (Tomcat).
3. Open:
   - `http://localhost:8080/MYJSP/` (welcome page)
   - `http://localhost:8080/MYJSP/test` (servlet output)
