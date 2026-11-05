# Lexicon OOP Workshop — Vending Machine

A Java console application for the Lexicon object-oriented programming workshop. Java 17+ and Maven are recommended.

## Run the included executable JAR

```bash
java -jar vending-machine.jar
```

## Build and test with Maven

```bash
mvn clean test
mvn package
java -jar target/vending-machine-1.0.0.jar
```

The Java source is in `src/main/java` and the JUnit 5 tests are in `src/test/java`.
No database or external service is required. The provided `vending-machine.jar` was built separately using `javac` and `jar` from the same source files.

## UML diagrams

The two Mermaid diagrams below describe the **actual implementation** in `src/main/java/se/lexicon/vending`. The overview emphasizes responsibilities and relationships; the detailed diagram includes every explicitly declared production field, constructor, and method. Test methods are documented separately under **Test coverage** because the JUnit test class is not part of the running application.

### 1. Overall architecture diagram

```mermaid
classDiagram
    direction LR
    class Product {
        <<abstract>>
    }
    class Snack
    class Beverage
    class Fruit
    class VendingMachine {
        <<interface>>
    }
    class VendingMachineImpl
    class ConsoleUI
    class Main
    class PurchaseException
    class RuntimeException

    Product <|-- Snack
    Product <|-- Beverage
    Product <|-- Fruit
    VendingMachine <|.. VendingMachineImpl
    RuntimeException <|-- PurchaseException
    VendingMachineImpl "1" o-- "0..*" Product : stocks
    ConsoleUI --> "1" VendingMachine : uses
    Main ..> VendingMachineImpl : creates
    Main ..> ConsoleUI : creates
    Main ..> Snack : creates
    Main ..> Beverage : creates
    Main ..> Fruit : creates
    VendingMachineImpl ..> PurchaseException : throws
    ConsoleUI ..> PurchaseException : catches
```

**Reading the relationships:** solid hollow-triangle arrows show inheritance (`<|--`); dashed hollow-triangle arrows show interface implementation (`<|..`); the hollow diamond marks aggregation of the product catalogue (`o--`); and dashed arrows indicate dependencies (`..>`). `1` means one object and `0..*` means zero or more objects. `RuntimeException` is a Java library superclass, included to clarify the exception hierarchy.

### 2. Detailed implementation-level class diagram

```mermaid
classDiagram
    direction TB
    class Product {
        <<abstract>>
        -int id
        -String name
        -int price
        -int quantity
        #Product(int id, String name, int price, int quantity)
        +getId() int
        +getName() String
        +getPrice() int
        +getQuantity() int
        +dispenseOne() void
        +getDescription()* String
    }
    class Snack {
        -int weightGrams
        +Snack(int id, String name, int price, int quantity, int weightGrams)
        +getWeightGrams() int
        +getDescription() String
    }
    class Beverage {
        -int volumeMl
        +Beverage(int id, String name, int price, int quantity, int volumeMl)
        +getVolumeMl() int
        +getDescription() String
    }
    class Fruit {
        -String origin
        +Fruit(int id, String name, int price, int quantity, String origin)
        +getOrigin() String
        +getDescription() String
    }
    class VendingMachine {
        <<interface>>
        +insertCoin(int coin) boolean
        +purchaseProduct(int id) Product
        +returnChange() int
        +getBalance() int
        +getLastReturnedChange() int
        +getProducts() List~Product~
    }
    class VendingMachineImpl {
        -Set~Integer~ VALID_COINS$
        -List~Product~ products
        -int balance
        -int lastReturnedChange
        +VendingMachineImpl(List~Product~ products)
        +insertCoin(int coin) boolean
        +purchaseProduct(int id) Product
        +returnChange() int
        +getBalance() int
        +getLastReturnedChange() int
        +getProducts() List~Product~
    }
    class ConsoleUI {
        -VendingMachine machine
        -Scanner scanner
        +ConsoleUI(VendingMachine machine, Scanner scanner)
        +start() void
        -showProducts() void
        -insertCoin() void
        -buyProduct() void
        -readInt() Integer
    }
    class Main {
        -Main()
        +main(String[] args)$ void
    }
    class PurchaseException {
        +PurchaseException(String message)
    }
    class RuntimeException

    Product <|-- Snack
    Product <|-- Beverage
    Product <|-- Fruit
    VendingMachine <|.. VendingMachineImpl
    RuntimeException <|-- PurchaseException
    VendingMachineImpl "1" o-- "0..*" Product : stocks
    ConsoleUI --> "1" VendingMachine : uses
    ConsoleUI --> "1" Scanner : reads input
    Main ..> VendingMachineImpl : creates
    Main ..> ConsoleUI : creates
    Main ..> Snack : creates
    Main ..> Beverage : creates
    Main ..> Fruit : creates
    VendingMachineImpl ..> PurchaseException : throws
    ConsoleUI ..> PurchaseException : catches
```

**UML notation:** `+` public, `-` private, `#` protected, `*` abstract operation, and `$` static member. Java `final` is not shown by standard visibility notation: `Product`'s `id`, `name`, and `price` are `final`, as are each subtype-specific field; the `products`, `machine`, and `scanner` references are also `final`. `VALID_COINS` is both `static` and `final`. The three product subclasses, `VendingMachineImpl`, `ConsoleUI`, `Main`, and `PurchaseException` are `final` classes. All four getters and `dispenseOne()` in `Product` are `final` methods. `Scanner` and `RuntimeException` are Java standard-library types, not project files.

> Diagram scope: The diagram shows all nine production types (including the `VendingMachine` interface and `PurchaseException`), but not inherited standard Java `Object` methods. The JUnit test class is kept out of the runtime diagram to avoid confusing test code with the application design.

## Business rules

- Product is abstract; three concrete classes override `getDescription()` with their own details.
- Only Swedish coin values `1, 2, 5, 10, 20, 50` are accepted.
- Invalid coins never change the balance.
- Missing/out-of-stock products and insufficient funds do not deduct money or stock.
- Successful purchases reduce the stock and automatically return any excess balance.
- `returnChange()` returns the current balance and resets it to zero.
- The console handles input/output; `VendingMachineImpl` contains the business rules.

## Optional challenge: duplicate-ID validation and defensive product list

The machine refuses duplicate product IDs and returns an unmodifiable list from `getProducts()`.
This prevents ambiguous purchases and accidental external modification of the stock catalog.
It demonstrates **encapsulation**, defensive programming, and preservation of class invariants.

## Test coverage

The 12 JUnit tests cover all seven workshop cases, automatic change, missing products, duplicate IDs, invalid constructors, encapsulation, and polymorphic descriptions.

## Submit

Initialize a repository (if needed), commit the code and push to your GitHub repository, then share its link with your instructor.

```bash
git init
git add .
git commit -m "Complete Lexicon OOP vending machine workshop"
# Add your own remote and push it using your preferred GitHub workflow.
```
