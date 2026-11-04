# Exercise 3 — Sports Club

## UML class diagram

```mermaid
classDiagram
    class Club
    class Team
    class Player

    Club "1" *-- "3" Team : consists of
    Team "0..1" o-- "0..*" Player : has / assigns
```

**Explanation:** Composition (`*--`) connects club and teams, whose lifetimes depend on the club. Aggregation (`o--`) connects teams and players, who survive team dissolution or transfer.

See `../Answers.md` for multiplicity and relationship reasoning.
