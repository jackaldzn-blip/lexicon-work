# Exercise solutions and expected results

These notes refer to the numbered tasks in the Lexicon SQL exercise handout. The original handout is not reproduced in this public repository.

| Exercise | SQL solution file | Explanation / expected result |
| --- | --- | --- |
| 1.1 | [01_database.sql](../sql/01_database.sql) | Create and select school_management. |
| 1.2 | [02_tables.sql](../sql/02_tables.sql) | Create courses with an auto-increment primary key and required name and credits. |
| 2.1 | [04_dml.sql](../sql/04_dml.sql) | Insert Java Programming (15), SQL Basics (10), Web Development (20). |
| 2.2 | [04_dml.sql](../sql/04_dml.sql) | Change Java Programming credits to 20. |
| 2.3 | [04_dml.sql](../sql/04_dml.sql) | Delete Web Development by its ID; two courses remain. |
| 3.1 | [05_dql.sql](../sql/05_dql.sql) | Return all five students. |
| 3.2 | [05_dql.sql](../sql/05_dql.sql) | Filter JAVA-A: John, Julia and Noah. |
| 3.3 | [05_dql.sql](../sql/05_dql.sql) | Match J%: John and Julia. |
| 4.1 | [06_joins.sql](../sql/06_joins.sql) | INNER JOIN yields eight matching attendance rows. |
| 4.2 | [06_joins.sql](../sql/06_joins.sql) | LEFT JOIN yields nine rows, including Noah with NULL attendance. |
| 5.1 | [07_aggregation.sql](../sql/07_aggregation.sql) | COUNT(*) returns 5. |
| 5.2 | [07_aggregation.sql](../sql/07_aggregation.sql) | GROUP BY status returns Absent: 3 and Present: 5. |
| 5.3 | [07_aggregation.sql](../sql/07_aggregation.sql) | Count present days for each student, including those with zero. |

## Expected output for exercise 5.3

| name | present_days |
| --- | ---: |
| John Andersson | 2 |
| Julia Lind | 1 |
| Emma Berg | 1 |
| Omar Saleh | 1 |
| Noah Holm | 0 |

An INNER JOIN excludes unmatched records. A LEFT JOIN keeps every student; the joined fields are NULL when no record matches. In exercise 5.3 the Present filter is in the ON clause, rather than WHERE, and COUNT(a.id) ignores NULL. Grouping by ID as well as name avoids combining different students with identical names.

These expected values were confirmed by the local MySQL 8.4.9 run on 25 November 2026. See [test results](TEST_RESULTS.md).
