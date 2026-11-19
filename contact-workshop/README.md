# Contact App Workshop

A Java 25 Maven console application for managing contacts in a text file. Built for the Lexicon exception-handling workshop using the MVC pattern.

## Features

- Add, list, and search for contacts by name.
- Validate names and 10-digit phone numbers with `IllegalArgumentException`.
- Prevent duplicate names using `DuplicateContactException` (checked).
- Handle file problems using `ContactStorageException` (checked).
- Save contacts in `data/contacts.txt` using try-with-resources.
- Keep user interaction in the View and errors in a centralized `ExceptionHandler`.

## UML class diagram

```mermaid
classDiagram
    direction TB
    class App {
        +main(String[] args)$ void
    }
    class Contact {
        -String name
        -String phoneNumber
        +Contact(String name, String phoneNumber)
        +getName() String
        +setName(String name) void
        +getPhoneNumber() String
        +setPhoneNumber(String phoneNumber) void
    }
    class ContactDAO {
        <<interface>>
        +findAll() List~Contact~
        +save(Contact contact) void
        +findByName(String name) Contact
    }
    class FileContactDAOImpl {
        -Path filePath
        +FileContactDAOImpl(Path filePath)
    }
    class ContactView {
        +displayMenu() void
        +getUserInput(String prompt) String
        +displayContacts(List~Contact~ contacts) void
        +displayMessage(String message) void
        +displayError(String message) void
    }
    class ContactController {
        -ContactDAO contactDAO
        -ContactView contactView
        +run() void
    }
    class ExceptionHandler {
        +handle(Exception e) void
    }
    class ContactStorageException
    class DuplicateContactException
    class Exception

    ContactDAO <|.. FileContactDAOImpl : implements
    App ..> ContactController : starts
    ContactController --> ContactDAO : uses
    ContactController --> ContactView : uses
    ContactController --> ExceptionHandler : handles errors
    ContactDAO ..> Contact : stores
    FileContactDAOImpl ..> ContactStorageException : throws
    FileContactDAOImpl ..> DuplicateContactException : throws
    Exception <|-- ContactStorageException
    Exception <|-- DuplicateContactException
    ExceptionHandler --> ContactView : displays errors
```

**MVC:** `Contact` is the model; `ContactView` handles console input/output; `ContactController` coordinates actions; `ContactDAO` and `FileContactDAOImpl` handle persistence. Invalid model data throws an unchecked `IllegalArgumentException`; file and duplicate errors use checked exceptions.

## Build and run

Requirements: **JDK 25** and **Maven 3.9+**.

From the `contact-workshop` folder:

```bash
mvn clean test
mvn package
java -cp target/classes se.lexicon.App
```

To choose a different contacts file:

```bash
java -cp target/classes se.lexicon.App contacts.txt
```

The default data file (`data/contacts.txt`) is created when you save your first contact and is excluded from Git.
