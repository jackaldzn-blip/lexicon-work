# Exercise 2 — University Departments

## UML class diagram

```mermaid
classDiagram
    class University
    class Department
    class Lecturer

    University "1" *-- "1..*" Department : consists of
    Department "0..*" o-- "0..*" Lecturer : has / teaches in
```

**Explanation:** Composition (`*--`) connects the university and its departments, because each department depends on the university. Aggregation (`o--`) connects departments and lecturers, who can be reassigned.

See `../Answers.md` for multiplicity and relationship reasoning.
