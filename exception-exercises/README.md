# Java Exception Handling — 8 Exercises

Solutions for all eight exercises in [Exception_Exercises.md](Exception_Exercises.md).

**One Maven project, one `pom.xml`.** The exercises are independent Java programs organized into eight packages inside the standard Maven source directory. No separate Maven modules are needed.

## Folder structure

```text
exception-exercises/
├── pom.xml
├── src/main/java/se/lexicon/exceptions/
│   ├── exercise01/Exercise1.java
│   ├── exercise02/Exercise2.java, OutOfRangeException.java
│   ├── exercise03/Exercise3.java, BankAccount.java, InsufficientBalanceException.java
│   ├── exercise04/Exercise4.java
│   ├── exercise05/Exercise5.java
│   ├── exercise06/Exercise6.java
│   ├── exercise07/Exercise7.java, NameManager.java, DuplicateNameException.java, NameNotFoundException.java
│   └── exercise08/Exercise8.java
├── samples/exercise-04/numbers.txt
├── samples/exercise-04/numbers-invalid.txt
├── run.ps1
└── run.sh
```

## VS Code

Open the `lexicon-work` repository in VS Code with the Java Extension Pack installed. Maven should import `exception-exercises/pom.xml` automatically. This project uses the standard source path `src/main/java` so Java files should be recognized as project files.

1. Expand `exception-exercises/src/main/java/se/lexicon/exceptions`.
2. Choose an exercise package and open its `ExerciseN.java`.
3. Select **Run** above `main`.

If VS Code still reports **"non-project file"**, open Command Palette (`Ctrl+Shift+P`), run **Java: Clean Java Language Server Workspace**, choose **Restart and delete**, and then **Java: Import Java Projects** or **Java: Update Project**.

## Build

Requires Java 17 or later. From the repository root:

```powershell
mvn -f exception-exercises/pom.xml clean compile
```

## Run an exercise

To run without Maven, open PowerShell in the `exception-exercises` directory:

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

On Linux/macOS use `./run.sh 1` (replace the number with an exercise between 1 and 8).

Each run script compiles the entire Java project into the ignored `build/classes` directory and launches only the chosen main class.

## Notes

- Exercise 1: try first number `10` and second number `0`.
- Exercise 2: try `50`, `abc` and `150`.
- Exercise 3: deposit funds, withdraw funds, then try to withdraw more than the balance.
- Exercise 4: the default sample is `samples/exercise-04/numbers.txt`. For parsing errors use `samples/exercise-04/numbers-invalid.txt`, and for missing-file errors use `missing.txt`.
- Exercise 5: test division by zero; the `finally` message still appears.
- Exercise 6: test `name@example.com` and `not-an-email`.
- Exercise 7: add Alice twice, then search for an unknown name.
- Exercise 8: the text is written to `output.txt` in the working directory and the file is ignored by Git.

`BankAccount` uses `double` for teaching purposes; production financial systems should use decimal monetary types such as `BigDecimal`.
