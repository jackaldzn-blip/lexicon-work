# Lambda & Stream exercises

This project solves **all core and optional exercises** from `Exercises.md` using the same simple lambda and Stream syntax practiced in class.

## Start here

Open `src/main/java/se/lexicon/lambdastream/Main.java` and read from top to bottom.

- **Part 1** uses simple lambdas and normal `for` loops.
- **Part 2** uses short Stream pipelines directly in `main`.
- **OptionalExercises.java** contains all the extra-practice tasks. You can ignore it until you are comfortable with `Main.java`.

## Classes

- `Person.java` — stores a person's name, age, city and active status (given starter class).
- `PersonRule.java` — checks a person and returns true or false (**required** by Part 1).
- `PersonAction.java` — performs an action with a person (**required** by Part 1).
- `PersonProcessor.java` — contains `filterPeople`, `findPeople`, and `applyToMatching` (**required** by Part 1).
- `Main.java` — shows the core exercises **directly**, one after another.
- `OptionalExercises.java` — extra exercises, kept separate to avoid distracting from the core tasks.

## Run with VS Code

Extract this project folder beside your other Lexicon projects, open the folder in VS Code, and run `Main.java` using **Run**.

Or from a terminal in this project folder:

```powershell
mvn compile exec:java
```

Requires Java 17 or newer. The project is Maven-compatible (`pom.xml`).

## Reflection questions

1. **Loop vs stream?** The stream is often shorter for filtering, mapping, and sorting. The loop may be easier to understand at first.
2. **Transformations vs actions?** `map()` transforms data; `filter()` selects it. `System.out.println()` is an action that prints information.
3. **Where do Predicate, Function, and Consumer fit?** `Predicate` checks true/false, `Function` transforms a value (like a `Person` into a `String`), and `Consumer` performs an action (like printing). Stream `filter` and `map` use these ideas.
