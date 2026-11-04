# Exercise 1 — The Bank

## UML class diagram

```mermaid
classDiagram
    class Account {
        <<abstract>>
        - holder: String
        - balance: double
        + Account(holder, balance)
        + getHolder() String
        + getBalance() double
        + deposit(amount double)
        + processMonth()
        + printSummary()
    }
    class SavingsAccount {
        - interestRate: double
        + SavingsAccount(holder, balance, interestRate)
        + processMonth()
    }
    class CheckingAccount {
        - monthlyFee: double
        + CheckingAccount(holder, balance, monthlyFee)
        + processMonth()
    }
    class LoanAccount {
        - loanRate: double
        + LoanAccount(holder, balance, loanRate)
        + processMonth()
    }
    class Bank {
        - name: String
        - accounts: List~Account~
        + Bank(name)
        + addAccount(account Account)
        + processAllAccounts()
        + printAllSummaries()
    }
    Account <|-- SavingsAccount
    Account <|-- CheckingAccount
    Account <|-- LoanAccount
    Bank "1" o-- "0..*" Account : manages
```

**Relationships:** `Account` is an abstract superclass; the three account types inherit from it. `Bank` aggregates `Account` objects that can exist independently of the bank.
