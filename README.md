# Books & Authors Management System

A Spring Boot CRUD application to manage books and their authors, supporting create, read, and update operations. The application uses JPA with a relational database, features clear entity relationships, and provides a JSP web interface for user interaction.

## Features

- **Authors**: Create, view, and update author details (name, nationality, birth year).
- **Books**: Create, view, and update book details (title, genre, published year) and associate each book with an author.
- **Entity Relationships**: One-to-many mapping between authors and books.
- **Web Interface**: User-friendly JSP pages for CRUD operations with CSS styling.
- **Custom Queries**: Advanced join queries displayed in list views.
- **Testing**: Unit tests for repositories and services using JUnit and Mockito.

## Tech Stack

- Java 17+
- Spring Boot 3.x
- Spring Data JPA (Hibernate)
- JSP, JSTL
- H2 (in-memory) or your preferred relational database
- JUnit, Mockito
- Maven

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- Git

### Installation

1. **Clone the repository**
   ```sh
   git clone https://github.com/hashenoy/spring-boot-app.git
   cd spring-boot-app
   ```

2. **Build the project**
   ```sh
   mvn clean install
   ```

3. **Run the application**
   ```sh
   mvn spring-boot:run
   ```
   The app will start at [http://localhost:8080](http://localhost:8080).

### Database Initialization

- On startup, the application will auto-generate tables and populate them with 10 classical authors and 10 books using a DataInitializer component.

## Usage

- Browse to `/authors/list` to view all authors.
- Use navigation links to add new authors (`/authors/add`), edit them, view books, or add/update books similarly.
- All data binding is managed automatically via JSP/JSTL.

## Project Structure

```
src/
 ├─ main/
 │   ├─ java/
 │   │   └─ com.example.demo/
 │   │        ├─ model/
 │   │        ├─ repository/
 │   │        ├─ service/
 │   │        ├─ controller/
 │   │        └─ DataInitializer.java
 │   └─ resources/
 │       ├─ templates/          # JSP files
 │       ├─ static/             # CSS
 │       └─ application.properties
 └─ test/
     └─ java/...
```

## Testing

- Unit and integration tests are included for repository and service layers.
- Run all tests:
  ```sh
  mvn test
  ```

## Custom Queries

- Repository layers include `@Query`-annotated methods to fetch authors with their books and vice versa for demonstration and read operations.

## Screenshots

_Add screenshots of listing pages and forms here, if available._

## Challenges

- Handling entity relationships to avoid infinite recursion in views.
- Data binding for complex relationships on JSP forms.
- Ensuring referential integrity and validation on user input.
- Robust testing of service and repository logic.

## License

MIT

***
