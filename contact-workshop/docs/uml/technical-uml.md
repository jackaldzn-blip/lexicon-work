# Technical UML and architecture — Contact App Workshop

> **Java 25** | `se.lexicon:contact-app-workshop` | MVC + DAO + checked/unchecked exceptions | file-based persistence

This document diagrams the **actual implementation** in `src/main/java/se/lexicon`, rather than only the simplified conceptual class diagram supplied by the workshop. All seven diagrams below use **Mermaid** code blocks that render directly in GitHub Markdown. Each also has a matching editable `.mmd` source file in this directory. No exported images or alternative diagram languages are included.

## Source-of-truth and notation

- UML class and sequence diagrams use Mermaid's UML syntax. Component, activity, and deployment views use **Mermaid flowcharts** to document those UML concepts and are labeled as such; they are not strict UML 2.x element/connector notation.
- `ContactController` owns an `ExceptionHandler` instance. `ExceptionHandler.handle(Exception)` is **not static**.
- Java uses `Path` for file locations, UTF-8 text, and `BufferedReader`/`BufferedWriter` in try-with-resources. A missing file is an empty contact book.
- The application is **single-process**; there is no concurrency coordination or transactional storage. This is deliberate workshop scope; concurrent saves by independent processes are not synchronized.

## 1. Detailed UML class diagram

Exact types, fields, constructors, public/private operations, interface realization, dependencies, and exception hierarchy. `+` is public, `-` is private, and `<|..` means interface realization. Methods with `void` return types are shown explicitly; exception declarations are in the contract table below.

```mermaid
classDiagram
    direction TB
    namespace bootstrap {
        class App {
            +main(String[] args)$ void
        }
    }
    namespace model {
        class Contact {
            -String name
            -String phoneNumber
            +Contact(String name, String phoneNumber)
            +getName() String
            +setName(String name) void
            +getPhoneNumber() String
            +setPhoneNumber(String phoneNumber) void
            +toString() String
            +equals(Object other) boolean
            +hashCode() int
        }
    }
    namespace data {
        class ContactDAO {
            <<interface>>
            +findAll() List~Contact~
            +save(Contact contact) void
            +findByName(String name) Contact
        }
        class FileContactDAOImpl {
            -Path filePath
            +FileContactDAOImpl(Path filePath)
            +findAll() List~Contact~
            +save(Contact contact) void
            +findByName(String name) Contact
        }
    }
    namespace view {
        class ContactView {
            -Scanner scanner
            -PrintStream out
            +ContactView(Scanner scanner, PrintStream out)
            +displayMenu() void
            +getUserInput(String prompt) String
            +displayContacts(List~Contact~ contacts) void
            +displayMessage(String message) void
            +displayError(String message) void
        }
    }
    namespace controller {
        class ContactController {
            -ContactDAO contactDAO
            -ContactView contactView
            -ExceptionHandler exceptionHandler
            +ContactController(ContactDAO dao, ContactView view)
            +run() void
            -addContact() boolean
            -searchContact() boolean
        }
    }
    namespace exception {
        class ContactStorageException {
            +ContactStorageException(String message)
            +ContactStorageException(String message, Throwable cause)
        }
        class DuplicateContactException {
            +DuplicateContactException(String message)
        }
        class ExceptionHandler {
            -ContactView view
            +ExceptionHandler(ContactView view)
            +handle(Exception exception) void
        }
    }
    class Exception
    class RuntimeException
    class IllegalArgumentException

    ContactDAO <|.. FileContactDAOImpl : implements
    Exception <|-- ContactStorageException : checked
    Exception <|-- DuplicateContactException : checked
    Exception <|-- RuntimeException
    RuntimeException <|-- IllegalArgumentException : unchecked
    App ..> FileContactDAOImpl : creates
    App ..> ContactView : creates
    App ..> ContactController : starts
    ContactController --> ContactDAO : DAO contract
    ContactController --> ContactView : user interaction
    ContactController *-- ExceptionHandler : owns
    ContactController ..> Contact : constructs
    ContactDAO ..> Contact : persists
    FileContactDAOImpl ..> ContactStorageException : throws
    FileContactDAOImpl ..> DuplicateContactException : throws
    Contact ..> IllegalArgumentException : throws on invalid fields
    ExceptionHandler --> ContactView : displays error
```

## 2. Component and package architecture

Package-level view of the composition root and runtime dependencies. The diagram is a Mermaid flowchart representation of a component diagram: data persistence sits behind the DAO contract and only the View interacts with the terminal.

```mermaid
flowchart TB
    User([Console user])
    subgraph JVM[Java 25 process]
        direction TB
        Entry[App.main<br/>composition root]
        subgraph MVC[MVC application]
            direction LR
            View[ContactView<br/>Scanner + PrintStream]
            Controller[ContactController<br/>menu / orchestration]
            Model[Contact<br/>input invariants]
        end
        Handler[ExceptionHandler<br/>exception to display message]
        subgraph Persistence[Persistence boundary]
            Interface[ContactDAO<br/>interface]
            Impl[FileContactDAOImpl<br/>UTF-8 / try-with-resources]
        end
        Entry --> Controller
        Entry --> View
        Entry --> Impl
        Controller --> View
        Controller --> Model
        Controller --> Interface
        Interface -. implementation .-> Impl
        Controller --> Handler
        Handler --> View
    end
    Disk[(data/contacts.txt<br/>TSV, UTF-8)]
    User <--> View
    Impl <--> Disk
```

## 3. UML sequence: add contact (including failures)

Follow the add action from prompts and validation through duplicate checking and UTF-8 append. The alternative branches cover the three principal outcomes: invalid input, duplicate record, and a storage failure.

```mermaid
sequenceDiagram
    autonumber
    actor User
    participant View as ContactView
    participant Ctrl as ContactController
    participant Contact as Contact (model)
    participant DAO as FileContactDAOImpl
    participant Disk as contacts.txt
    participant Handler as ExceptionHandler
    Ctrl->>View: getUserInput("Name: ")
    View->>User: display prompt
    User-->>View: Anna
    View-->>Ctrl: "Anna"
    Ctrl->>View: getUserInput("Phone number (10 digits): ")
    View->>User: display prompt
    User-->>View: 0123456789
    View-->>Ctrl: "0123456789"
    Ctrl->>Contact: new Contact("Anna", "0123456789")
    Contact->>Contact: setName() and setPhoneNumber()
    alt Invalid name or phone number
        Contact--xCtrl: IllegalArgumentException
        Ctrl->>Handler: handle(exception)
        Handler->>View: displayError("Invalid input: ...")
    else Valid contact
        Contact-->>Ctrl: valid Contact
        Ctrl->>DAO: save(contact)
        DAO->>DAO: findAll() to check stored contacts
        opt File already exists
            DAO->>Disk: read all records (try-with-resources)
            Disk-->>DAO: stored contact lines
            DAO->>DAO: parse and validate all records
        end
        alt Duplicate name (case-insensitive)
            DAO--xCtrl: DuplicateContactException
            Ctrl->>Handler: handle(exception)
            Handler->>View: displayError("... already exists")
        else Storage / parse failure
            DAO--xCtrl: ContactStorageException
            Ctrl->>Handler: handle(exception)
            Handler->>View: displayError("Contact storage problem: ...")
        else New unique contact
            DAO->>DAO: create parent directories if needed
            DAO->>Disk: append TAB-separated contact (UTF-8 BufferedWriter)
            Disk-->>DAO: append completes, writer auto-closes
            DAO-->>Ctrl: return
            Ctrl->>View: displayMessage("Contact saved successfully.")
        end
    end
```

## 4. UML sequence: list and find contacts

Both list and search call into the same `findAll()` loader. `findByName()` performs its own query validation, then iterates over loaded contacts. A missing file is treated as empty storage; corrupt data is not.

```mermaid
sequenceDiagram
    autonumber
    actor User
    participant View as ContactView
    participant Ctrl as ContactController
    participant DAO as FileContactDAOImpl
    participant Contact as Contact (model)
    participant Disk as contacts.txt
    participant Handler as ExceptionHandler
    User->>View: Select 1 (list) or 3 (find by name)
    View-->>Ctrl: menu choice
    alt List all (1)
        Ctrl->>DAO: findAll()
    else Find by name (3)
        Ctrl->>View: getUserInput("Name to search: ")
        View-->>Ctrl: search name
        Ctrl->>DAO: findByName(name)
        DAO->>DAO: trim and validate search name
        DAO->>DAO: findAll()
    end
    alt File absent
        DAO-->>Ctrl: empty list / null
    else File exists and is valid
        DAO->>Disk: open UTF-8 BufferedReader
        loop Each persisted line
            Disk-->>DAO: name TAB phone
            DAO->>DAO: split on TAB and check fields
            DAO->>Contact: new Contact(name, phone)
            Contact-->>DAO: validated contact
            DAO->>DAO: ensure unique stored name
        end
        DAO->>Disk: close reader automatically
        DAO-->>Ctrl: List of contacts / matching Contact or null
    else Bad data or IO error
        DAO--xCtrl: ContactStorageException
        Ctrl->>Handler: handle(exception)
        Handler->>View: displayError("Contact storage problem: ...")
    end
    opt Successful DAO result
        Ctrl->>View: displayContacts(...) or displayMessage(...)
        View->>User: contacts / no contacts found
    end
```

## 5. Controller activity and menu loop

An activity-style flowchart showing decisions, recovery from exceptions, and the exit conditions. The `try/catch` covers each selected menu action; exceptions are presented via the central handler and control returns to the menu.

```mermaid
flowchart TD
    Start([Start App.main]) --> Wire[Create DAO, View and Controller]
    Wire --> Welcome[Display welcome message]
    Welcome --> Menu[Display menu]
    Menu --> Read[Read choice]
    Read --> EOF{End of input?}
    EOF -- Yes --> Exit[Display Goodbye]
    EOF -- No --> Try[Enter controller try/catch]
    Try --> Choice{Choice}
    Choice -- 1 --> List[DAO.findAll; displayContacts]
    Choice -- 2 --> Add[Prompt name and phone; create Contact; DAO.save]
    Choice -- 3 --> Search[Prompt name; DAO.findByName; show result]
    Choice -- 0 --> Exit
    Choice -- Other --> Invalid[Display unknown-option error]
    List --> Thrown{Exception?}
    Add --> Thrown
    Search --> Thrown
    Thrown -- Yes --> Handler[ExceptionHandler.handle]
    Thrown -- No --> More{Input ended during operation?}
    Handler --> Menu
    More -- Yes --> Exit
    More -- No --> Menu
    Invalid --> Menu
    Exit --> End([End])
```

## 6. UML exception hierarchy

Unchecked `IllegalArgumentException` comes from `RuntimeException`. Both workshop-specific exceptions derive directly from `Exception` (checked). IO errors and invalid persisted records are wrapped in `ContactStorageException`.

```mermaid
classDiagram
    direction TB
    class Throwable
    class Exception
    class RuntimeException
    class IllegalArgumentException
    class IOException
    class ContactStorageException {
        +ContactStorageException(String message)
        +ContactStorageException(String message, Throwable cause)
    }
    class DuplicateContactException {
        +DuplicateContactException(String message)
    }
    class ExceptionHandler {
        +handle(Exception exception) void
    }
    Throwable <|-- Exception
    Exception <|-- RuntimeException
    RuntimeException <|-- IllegalArgumentException
    Exception <|-- IOException
    Exception <|-- ContactStorageException
    Exception <|-- DuplicateContactException
    IOException ..> ContactStorageException : wrapped as cause
    IllegalArgumentException ..> ContactStorageException : malformed file values wrapped
    ExceptionHandler ..> ContactStorageException : formats error
    ExceptionHandler ..> DuplicateContactException : formats error
    ExceptionHandler ..> IllegalArgumentException : formats error
```

## 7. Runtime deployment and file persistence

A deployment-style flowchart for a single JVM process on a developer computer. No web server or database is involved. The relative path is resolved against the process working directory.

```mermaid
flowchart LR
    subgraph Machine[Developer machine / CLI]
        User([Terminal])
        subgraph JDK[JDK 25 runtime]
            App[se.lexicon.App<br/>JVM process]
            View[ContactView<br/>Scanner / PrintStream]
            DAO[FileContactDAOImpl<br/>java.nio.file.Files]
            App --> View
            App --> DAO
        end
        subgraph FS[Local filesystem]
            Directory[data directory<br/>auto-created when saving]
            File[(contacts.txt<br/>UTF-8 text / TSV)]
            Directory --> File
        end
        User <-->|stdin / stdout| View
        DAO <-->|BufferedReader / BufferedWriter| File
    end
```

## 8. Public interface and exception contract

| Declaring type | Operation | Return | Checked exceptions | Unchecked validation/errors |
|---|---|---|---|---|
| `Contact` | `Contact(name, phoneNumber)` | instance | — | `IllegalArgumentException` for invalid name or phone |
| `Contact` | `setName(name)` | `void` | — | `IllegalArgumentException` for null/blank, TAB, CR or LF |
| `Contact` | `setPhoneNumber(phone)` | `void` | — | `IllegalArgumentException` unless exactly 10 ASCII digits |
| `ContactDAO` | `findAll()` | `List<Contact>` | `ContactStorageException` | — |
| `ContactDAO` | `save(contact)` | `void` | `ContactStorageException`, `DuplicateContactException` | `NullPointerException` for null contact |
| `ContactDAO` | `findByName(name)` | `Contact` or `null` | `ContactStorageException` | `IllegalArgumentException` for null/blank search |
| `ContactView` | `getUserInput(prompt)` | `String` or `null` on EOF | — | — |
| `ExceptionHandler` | `handle(exception)` | `void` | — | — |
| `ContactController` | `run()` | `void` | None leak from the loop's `catch (Exception)` | Error is shown, menu remains active |

In Java 25, exceptions' **checked or unchecked nature does not change**: a class extending `Exception` directly is checked; `IllegalArgumentException` extends `RuntimeException` and is unchecked.

## 9. File format and integrity rules

### Storage layout

```text
data/
  contacts.txt      # created on first successful save
```

Example file (the whitespace between name and number is one literal TAB):

```text
Anna	0123456789
Åsa, Björn	0987654321
```

| Concern | Behavior in implementation |
|---|---|
| Encoding | UTF-8 for both reading and writing |
| Record delimiter | One contact per line (line ending from OS when appended) |
| Field delimiter | Exactly one TAB; two fields required |
| Name validation | Must not be null/blank; trimmed; must not contain tab, carriage return or newline |
| Phone validation | `[0-9]{10}` (exactly ten ASCII digits) |
| Duplicate identity | Name compared ignoring case; phone numbers are **not** uniqueness keys |
| New file | Missing storage file is treated as an empty contact list |
| Corrupted record | `ContactStorageException`, with line number and original cause when available |
| Existing duplicates | `ContactStorageException` while loading the file |
| Write strategy | `CREATE + APPEND`; parent directories created before writing |
| Resource cleanup | `BufferedReader` and `BufferedWriter` automatically closed via try-with-resources |
| Important limitation | Append is not a concurrent multi-process transaction; no file locking or atomic rewrite |

## 10. Design decisions and traceability

| Requirement from Lexicon workshop | Implementation | Verification |
|---|---|---|
| MVC pattern | `model`, `view`, `controller` packages, `App` composition root | `ContactControllerTest` |
| Unchecked validation | `Contact.setName`, `Contact.setPhoneNumber` | `ContactTest` |
| Custom checked exceptions | `ContactStorageException`, `DuplicateContactException` | `FileContactDAOImplTest` |
| DAO decoupling | `ContactDAO` interface, `FileContactDAOImpl` | `FileContactDAOImplTest` |
| Try-with-resources | `FileContactDAOImpl.findAll` and `save` | `FileContactDAOImplTest` (including file errors) |
| Centralized exception handler | `ExceptionHandler.handle` called from controller's try/catch | `ContactControllerTest` |
| Clear bootstrapping | `App.main` constructs DAO, View, Controller | Manual console run |

### Package boundaries

- `model` knows no console, persistence, or controller dependencies.
- `data` knows `model` and checked exceptions; it never prints to the terminal.
- `view` knows only `model`, `java.util.Scanner`, and `java.io.PrintStream`.
- `controller` coordinates the View, Model and DAO, delegating error presentation.
- `exception.ExceptionHandler` maps exceptions into View messages without swallowing `Error` subclasses.
- `App` is the **composition root**; it wires the interfaces and starts the program.

### Notes for extensions (not implemented)

For production use, common extensions would include atomic write/replace, file locking, structured data storage, stable record identifiers, and international telephone validation. These are **not requirements** of this workshop and are intentionally not represented as implemented features in the UML.

## 11. Where to inspect the diagrams

- **GitHub preview:** open [`technical-uml.md`](technical-uml.md) for all seven Mermaid diagrams, or [`README.md`](../../README.md) for the class diagram.
- **Editable sources:** the seven [`*.mmd`](./) files in this folder. These are plain-text Mermaid sources.
- **Editing:** use a `mermaid` fenced code block in Markdown for GitHub rendering; update the corresponding `.mmd` source when changing a diagram.
- **Original conceptual model:** [`Exception_Workshop.md`](../../Exception_Workshop.md).
