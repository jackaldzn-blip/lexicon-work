# Java + Maven: First Project Setup

## 1. Check Java

Open PowerShell:

```powershell
java -version
javac -version
echo $env:JAVA_HOME
```

If Java is missing, install a JDK such as Temurin:

```powershell
winget install EclipseAdoptium.Temurin.25.JDK
```

Restart PowerShell after installation.

---

## 2. Install Maven

Download and extract Apache Maven to:

```text
C:\Program Files\Apache\Maven\apache-maven-3.10.0
```

Set Maven environment variables in **PowerShell as Administrator**:

```powershell
[Environment]::SetEnvironmentVariable(
    "MAVEN_HOME",
    "C:\Program Files\Apache\Maven\apache-maven-3.10.0",
    "Machine"
)

$oldPath = [Environment]::GetEnvironmentVariable("Path", "Machine")

[Environment]::SetEnvironmentVariable(
    "Path",
    $oldPath + ";C:\Program Files\Apache\Maven\apache-maven-3.10.0\bin",
    "Machine"
)
```

Restart PowerShell or VS Code, then check:

```powershell
mvn -version
```

---

## 3. Create the Project

Recommended structure:

```text
demo/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── example/
                    └── Main.java
```

### `pom.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             https://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>demo</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.release>17</maven.compiler.release>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

</project>
```

### `Main.java`

```java
package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Maven!");
    }
}
```

---

## 4. Compile

From the folder containing `pom.xml`:

```powershell
mvn clean compile
```

Successful build:

```text
BUILD SUCCESS
```

Compiled classes are placed in:

```text
target\classes
```

---

## 5. Run

```powershell
java -cp target\classes com.example.Main
```

Output:

```text
Hello Maven!
```

---

## Useful Commands

```powershell
mvn clean          # Delete previous build files
mvn compile        # Compile source code
mvn test           # Run tests
mvn package        # Build the JAR/package
mvn clean package  # Clean, compile, test, and package
```

> VS Code's Java extension may compile saved Java files automatically. The `java` command itself only runs already compiled `.class` files.
