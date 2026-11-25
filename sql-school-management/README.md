# SQL School Management — Lexicon Workshop

Solutions to all 13 SQL exercises, implemented as a standalone MySQL practice project. No Java, Maven or application framework is required.

## Requirements

- MySQL Server 8.0 or later, running locally.
- MySQL Workbench, the MySQL command-line client, or a VS Code MySQL client extension.
- A local MySQL account with permission to create and modify the practice database.

Official MySQL downloads: https://dev.mysql.com/downloads/

## Run the workshop

Use a fresh, dedicated practice database named school_management. If that database already contains lecture work or other data, back it up and use an isolated MySQL instance instead. The scripts are intended for a single run against empty tables; they do not automatically drop or overwrite existing tables.

Open each file in MySQL Workbench, connect to the local server, and execute the whole file in this order:

| File | Purpose |
| --- | --- |
| [01_database.sql](sql/01_database.sql) | Exercise 1.1: create database |
| [02_tables.sql](sql/02_tables.sql) | Exercise 1.2 and supporting table definitions |
| [03_sample_data.sql](sql/03_sample_data.sql) | Fictional student and attendance records |
| [04_dml.sql](sql/04_dml.sql) | Exercises 2.1–2.3: insert, update, delete |
| [05_dql.sql](sql/05_dql.sql) | Exercises 3.1–3.3: select, filter, pattern matching |
| [06_joins.sql](sql/06_joins.sql) | Exercises 4.1–4.2: inner and left joins |
| [07_aggregation.sql](sql/07_aggregation.sql) | Exercises 5.1–5.3: count and grouping |

Alternatively, in the VS Code PowerShell terminal, start the MySQL CLI from this project's folder (if mysql is on PATH):

```powershell
mysql -u root -p
```

Use your own local username if it is not root. Enter your password at the prompt, never in source code. At the mysql prompt:

```sql
SOURCE sql/01_database.sql;
SOURCE sql/02_tables.sql;
SOURCE sql/03_sample_data.sql;
SOURCE sql/04_dml.sql;
SOURCE sql/05_dql.sql;
SOURCE sql/06_joins.sql;
SOURCE sql/07_aggregation.sql;
```

Run the scripts in the same session or reconnect as needed; each script selects its database. Scripts 05–07 are read-only and can be repeated. Do not rerun the seed or DML scripts against the same data if you want the documented results.

## Verify the results

- Two courses remain after exercise 2.3; Java Programming has 20 credits.
- There are 5 students and 8 attendance records (5 Present, 3 Absent).
- The inner join returns 8 rows and the left join returns 9.
- The present-day report includes all five students, including Noah with zero.

See [all exercise solutions and expected results](docs/SOLUTIONS.md) and the [database design / ER diagram](docs/DATABASE_DESIGN.md).

## Scope and assumptions

The provided exercises explicitly define courses but refer to lecture tables student and attendance without supplying their full schemas. Minimal supporting schemas and fictional data are included to make this project runnable independently. They may differ from the lecture database. No original lecture material or credentials are published.

## Verification status

All seven scripts were executed locally on Windows using MySQL Server 8.4.9 on 25 November 2026. All 13 exercises passed with the documented results and no SQL errors reported. See the [acceptance test report](docs/TEST_RESULTS.md).
