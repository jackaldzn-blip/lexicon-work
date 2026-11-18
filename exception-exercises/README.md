# Java Exception Handling — 8 solved exercises

Beginner-friendly solutions for all eight tasks in `Exception_Exercises.md`. Each exercise is an independent Java console application.

## VS Code / Maven

The parent `pom.xml` defines **eight Maven modules**. Each exercise folder is its own source root, preserving its default-package classes and helping VS Code's Java extension recognize them as projects.

- Open the repository in VS Code and allow the Java / Maven extensions to import the projects.
- From the repository root run `mvn -f exception-exercises/pom.xml compile` to compile all exercises.
- Or open `Exercise1.java` (or any other exercise) and select **Run** after Java project import.

Requires **JDK 17+**. Maven is optional when using the run scripts.

If Java still reports a non-project file or an outdated Maven project, run **Java: Clean Java Language Server Workspace**, restart, then run **Java: Import Java Projects** or **Java: Update Project**.

## Run without Maven

From the `exception-exercises` folder, use PowerShell:

```powershell
.\run.ps1 1
.\run.ps1 2
.\run.ps1 3
.\run.ps1 4
.\run.ps1 5
.\run.ps1 6
.\run.ps1 7
.\run.ps1 8
```

On Linux / macOS: `./run.sh 1` (replace 1 with an exercise number from 1 through 8).

Scripts compile each exercise independently and put generated classes in ignored `build/` output directories.

## Exercise guide

| # | Topic | Main program |
| --- | --- | --- |
| 1 | Division by zero, invalid input | `exercise-01/Exercise1.java` |
| 2 | Custom out-of-range exception | `exercise-02/Exercise2.java` |
| 3 | Banking and insufficient balance | `exercise-03/Exercise3.java` |
| 4 | Nested file and numeric parsing errors | `exercise-04/Exercise4.java` |
| 5 | `finally` block | `exercise-05/Exercise5.java` |
| 6 | Email validation and `IllegalArgumentException` | `exercise-06/Exercise6.java` |
| 7 | Duplicate and missing names | `exercise-07/Exercise7.java` |
| 8 | File writing with try-with-resources | `exercise-08/Exercise8.java` |

## Verify behavior

- Exercise 1: enter 10 then 0; it handles division by zero.
- Exercise 2: try 50, abc, 150.
- Exercise 3: withdraw more than the available balance.
- Exercise 4: run from `exercise-04`; enter `numbers.txt`, `numbers-invalid.txt` or `missing.txt`.
- Exercise 5: enter 10 then 0; the finally message prints as well.
- Exercise 6: test `name@example.com` and `not-an-email`.
- Exercise 7: add Alice twice; search for Nobody.
- Exercise 8: enter a sentence and inspect `output.txt` in the current directory.

Each program has an independent `main` method. Input scanners are closed by try-with-resources. Banking uses `double` for classroom simplicity; real financial systems should use `BigDecimal`.
