# Library Management System

## Overview
The Library Management System is a Spring Boot-based RESTful API application designed to manage a library's inventory. It allows users to perform CRUD operations on books and provides robust exception handling, ensuring smooth functionality.

---

## Functional Requirements

### 1. Add a Book
- **Description**: Add a new book to the library inventory via REST API.
- **Input Details**:
    - `Book ID` (unique identifier, integer)
    - `Title` (string)
    - `Author` (string)
    - `Publication Year` (integer)
    - `Genre` (string)
- **Output**: JSON response confirming successful addition or throwing an error for duplicates.
- **Covered Topics**:
    - OOP: `Book` as a Java class with properties and methods.
    - Collections: Store books in an in-memory `List<Book>`.
    - Generics: Ensure type safety in the `List`.
    - Spring Features:
        - REST controller (`@RestController`) for API endpoints.
        - Service (`@Service`) for business logic.

### 2. Remove a Book
- **Description**: Remove a book by its ID or Title via REST API.
- **Input Details**:
    - `Book ID` (integer) or `Title` (string).
- **Output**:
    - If found: JSON response with removed book details.
    - If not found: JSON error message.
- **Covered Topics**:
    - Collections: Use `List` operations to find and remove the book.
    - Exception Handling:
        - Custom exception `BookNotFoundException` for invalid or missing input.
    - Spring Features:
        - Exception handling with `@ControllerAdvice` and `@ExceptionHandler`.

### 3. Search for a Book
- **Description**: Search for a book by one or more criteria via REST API.
- **Input Details**:
    - `Title` (string, partial matches allowed).
    - `Author` (string, exact match).
    - `Publication Year` (integer, optional filter).
- **Output**:
    - List of books matching the criteria (JSON).
    - If none found: JSON error message.
- **Covered Topics**:
    - Streams: Use filtering, mapping, and sorting operations for search.
    - Collections: Search operations within a `List`.
    - Spring Features:
        - Query parameters in REST APIs (`@RequestParam`).

### 4. Display All Books
- **Description**: Provide an endpoint to display all books in the inventory.
- **Output**:
    - JSON response with a list of all books, each with:
        - `Book ID`, `Title`, `Author`, `Publication Year`, `Genre`.
- **Covered Topics**:
    - Collections: Iterate through the `List` of books.
    - Streams: Sort books by `Title` or `Publication Year`.
    - Spring Features:
        - REST endpoint for fetching all books (`GET /books`).

### 5. Exception Handling
- **Scenarios to Handle**:
    - Adding a book with a duplicate ID.
    - Removing a book that doesn't exist.
    - Searching with invalid criteria (e.g., invalid publication year input).
- **Covered Topics**:
    - Custom exceptions (`DuplicateBookException`, `BookNotFoundException`).
    - Exception handling using `@ControllerAdvice` and `@ExceptionHandler`.

### 6. Singleton Design Pattern
- **Description**: Ensure the library inventory is managed through a single instance.
- **Implementation**:
    - Use the Singleton pattern for the `LibraryService` class.
- **Covered Topics**:
    - Singleton pattern implementation in Spring Boot (achieved through `@Service` which is inherently a Singleton).

### 7. Factory Design Pattern
- **Description**: Create a factory to handle dynamic creation of `Book` objects.
- **Implementation**:
    - Use a `BookFactory` class to create `Book` objects.
    - Inject the factory into the `LibraryService`.
- **Covered Topics**:
    - Factory design pattern.

### 8. Exit the Program
- **Description**: Provide an endpoint to safely terminate the application.
- **Implementation**:
    - Use a REST API (`POST /exit`) that shuts down the Spring Boot application gracefully.
    - Optional: Log unsaved changes (if required).
- **Covered Topics**:
    - Use `ApplicationContext` to trigger a shutdown.

---

## Example Directory Structure
```
src/main/java/com/librarymanagement/
├── controller/
│   ├── BookController.java         // REST API endpoints
├── service/
│   ├── LibraryService.java         // Business logic
├── factory/
│   ├── BookFactory.java            // Factory for creating Book objects
├── exception/
│   ├── BookNotFoundException.java  // Custom exceptions
│   ├── DuplicateBookException.java
├── model/
│   ├── Book.java                   // Book class
├── LibraryManagementApplication.java  // Main Spring Boot application
```

---

## Technologies Used

### Spring Boot
- REST Controllers (`@RestController`)
- Dependency Injection (`@Service`, `@Component`)
- Exception Handling (`@ControllerAdvice`)

### Java 8+ Features
- Streams API
- Functional programming for filtering and sorting

### In-Memory Storage
- Use a `List` to store book data.