# JDBC - Student Data Retrieval

This project is part of my Udemy AJ course learning submission.

## Tech description

JDBC (Java Database Connectivity) is the standard API for connecting Java programs to relational databases. It uses connections, statements, and result sets to execute SQL and read data.

## What I built

- A console app that connects to MySQL and prints student records from the `students` table.
- The JDBC flow is demonstrated in `RetrieveData.java`.

## Flow / working

1. `RetrieveData` opens a connection with `DriverManager`.
2. A SQL query (`SELECT * FROM students`) runs via a `Statement`.
3. Results are read from the `ResultSet` and printed to the console.

## How to run

1. Update DB settings in `src/main/java/org/example/RetrieveData.java` (URL, username, password).
2. Ensure the database and `students` table exist.
3. From this folder, run:

   mvn -q -Dexec.mainClass=org.example.RetrieveData -Dexec.classpathScope=runtime org.codehaus.mojo:exec-maven-plugin:3.1.0:java

Or run `RetrieveData` directly from your IDE.
