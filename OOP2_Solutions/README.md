# OOP 2 — Solved Exercises

Solutions for all four exercises, including a VS Code-ready Java project for Exercise 1.

## Folder guide

- `Exercise1_Bank/` — Maven-compatible project with all six Java classes, a dependency-free assertion test and `run.ps1`.
- `UML_Diagrams/` — four **separate `.md` files** containing Mermaid class diagrams and explanations.
- `Answers.md` — full written answers and multiplicities for Exercises 1–4.

## How to open in VS Code (recommended)

**Important:** Open `OOP2_Solutions/Exercise1_Bank` as its own folder using **File > Open Folder**. Do not run `App.java` as a single standalone Java file: it depends on the other classes.

The `pom.xml` identifies `src/main/java` as the application source folder and lets the Java extension resolve `Account`, `Bank` and all three subclasses. It has a unique Maven group/artifact coordinate to avoid colliding with other projects.

1. In VS Code: **File > Open Folder** > select `Exercise1_Bank`.
2. Wait for the Java project to finish importing.
3. Open `src/main/java/App.java` and choose **Run**, or use **Run and Debug** > `Run OOP2 Bank (App)`.
4. Alternatively, in the integrated PowerShell terminal run `./run.ps1` from `Exercise1_Bank`. This compiles and runs the app and its assertions even if VS Code's Java project import is broken.

**Requires JDK 17 or later.** No third-party libraries are needed for the PowerShell script.

Expected updated balances: Ali **1020.00 kr**, Sara **475.00 kr**, Omar **5150.00 kr**.


## UML diagrams

Open the `UML_Diagrams/*.md` files in GitHub or a VS Code Markdown preview with Mermaid support.
