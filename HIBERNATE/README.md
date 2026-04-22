Library Management System — Hibernate migration

What I will do next
- Summarize changes made: annotated `Book` entity, `hibernate.cfg.xml`, `HibernateUtil`, `BookDAO`, two servlets, updated `index.jsp`, and `pom.xml`.
- Provide instructions to build and run locally, since this environment doesn't have Maven installed.
- Provide SQL / DB notes and where to change DB credentials.
- Provide a concise compare/contrast: Hibernate vs plain JDBC and guidance when to prefer Hibernate.

Files added/modified
- `pom.xml` — added Hibernate, MySQL connector, JPA API, SLF4J and transaction API dependencies.
- `src/main/resources/hibernate.cfg.xml` — Hibernate configuration (edit DB URL/username/password).
- `src/main/java/org/example/model/Book.java` — Annotated entity mapped to `books` table.
- `src/main/java/org/example/util/HibernateUtil.java` — SessionFactory bootstrap helper.
- `src/main/java/org/example/dao/BookDAO.java` — CRUD operations using Hibernate `Session` and `Transaction`.
- `src/main/java/org/example/servlet/ListBooksServlet.java` — Lists books and forwards to `/index.jsp`.
- `src/main/java/org/example/servlet/BookServlet.java` — Handles create/update/delete via `BookDAO`.
- `src/main/webapp/index.jsp` — Simple UI to list/add/update/delete books.
- `src/main/webapp/WEB-INF/web.xml` — minimal web.xml with welcome page.

Database setup
1. Install MySQL and create a database `library_db` (or update `hibernate.cfg.xml` to match your DB):

   CREATE DATABASE library_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

2. Edit `src/main/resources/hibernate.cfg.xml` and set the `connection.username` and `connection.password` properties to your MySQL credentials. The URL is currently:

   jdbc:mysql://localhost:3306/library_db?useSSL=false&serverTimezone=UTC

3. The `hibernate.hbm2ddl.auto` property is set to `update` so Hibernate will create/update the `books` table automatically during development.

Build & run (local machine)
1. Ensure Java 8+ and Maven are installed. Maven must be on PATH (e.g., `mvn -v` should succeed).
2. From the project root run:

   mvn clean package

3. Deploy the generated WAR (`target/TakeHomeExam-4-Hibernate.war`) to a servlet container (Tomcat 9+/Jakarta compatibility may vary). Alternatively, run in an IDE that supports webapp deployments.

Notes about missing tools in this environment
- This environment doesn't have Maven available, so I couldn't download dependencies or run a compile step here. When you run `mvn package` locally it will download Hibernate, MySQL connector, and other dependencies and then compile the project.

Hibernate vs JDBC — short comparison
- Development effort
  - JDBC: More boilerplate — manual connection, prepared statements, result set mapping to objects. Every CRUD operation requires repeating boilerplate and careful resource management.
  - Hibernate: Less boilerplate — map classes to tables with annotations/XML and use Sessions. CRUD is simpler (save/update/delete) and object mapping is automatic.

- Query language
  - JDBC: Plain SQL. Powerful and portable; you're writing vendor-specific SQL if you rely on DB-specific features.
  - Hibernate: HQL/JPQL (object-oriented query language) and Criteria API. HQL operates on entities and properties instead of tables and columns. You can still execute native SQL when needed.

- Caching
  - JDBC: No built-in caching. You implement caching yourself or use separate caching layers.
  - Hibernate: First-level cache (Session) always present; optional second-level cache (shared across sessions) via providers (Ehcache, Infinispan) reduces DB hits.

- Lazy loading
  - JDBC: No automatic lazy loading of related entities; you must explicitly query what you need.
  - Hibernate: Supports lazy loading for associations (collections, many-to-one). This avoids loading large graphs until needed, but requires managing session scope to avoid LazyInitializationException.

- Suitability in J2EE multi-tier apps
  - JDBC: Good for very simple apps or when you need fine-grained control over SQL/queries and database features. Easier to reason about for trivial cases.
  - Hibernate: Better for complex domain models, drastically reduces boilerplate, integrates well in multi-tier J2EE apps. Its caching and session management improve performance when used correctly.

When to prefer Hibernate
- Prefer Hibernate when you have a complex domain model with many relationships, want to reduce repetitive CRUD boilerplate, need caching or lazy-loading semantics, and want portability across databases.
- Use plain JDBC when you need extreme control, raw performance tuning for specific SQL, or minimal dependencies for a tiny app.

Next steps I can take for you
- If you want, I can change `hbm2ddl.auto` to `validate`/`none` for production readiness and add a SQL migration script (Flyway/Liquibase).
- Add unit/integration tests for `BookDAO` (requires an embedded DB or testcontainers).
- Integrate a second-level cache and demonstrate lazy loading with a related entity (e.g., Category/Author).

Status checklist
- Create annotated `Book` entity — Done (`src/main/java/org/example/model/Book.java`).
- Configure Hibernate (hibernate.cfg.xml) — Done (`src/main/resources/hibernate.cfg.xml`).
- Implement `HibernateUtil` and `BookDAO` — Done (`src/main/java/org/example/util/HibernateUtil.java`, `src/main/java/org/example/dao/BookDAO.java`).
- Update Servlets to use Hibernate DAO — Done (`src/main/java/org/example/servlet/*.java`).
- Build & test locally — Deferred (Maven not available in this environment). Run `mvn clean package` locally to compile and fetch dependencies.

If you'd like, I can now:
- Update `hibernate.cfg.xml` to use environment variables (safer than hardcoding credentials), or
- Add Flyway with an initial migration SQL script and set `hbm2ddl.auto` to `validate` for production.

Tell me which of those you'd like next, or run `mvn clean package` locally and then I can help with any compile/runtime issues you hit.
