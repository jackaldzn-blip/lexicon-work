# Exercise 4 — Customer Orders

## UML class diagram

```mermaid
classDiagram
    class Customer
    class Order
    class OrderLine {
        +quantity: int
    }
    class Product

    Order "1" *-- "1..*" OrderLine : contains
    OrderLine "0..*" --> "1" Product : references
    Customer "1" --> "0..*" Order : places
```

**Explanation:** Composition (`*--`) connects orders to order lines. Associations (`-->`) link order lines to catalog products and customers to orders.

See `../Answers.md` for multiplicity and relationship reasoning.
