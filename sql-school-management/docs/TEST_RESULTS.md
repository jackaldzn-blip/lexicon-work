# SQL workshop acceptance test report

- Date: 25 November 2026
- Environment: Windows, MySQL Community Server 8.4.9, MySQL CLI
- Tested implementation: `07b6e0c48068a76112548366b37b6fdb845de165`
- Method: manual execution of all seven scripts in order against a newly created practice database; review of the supplied terminal output.
- Result: **13/13 exercises passed**. No SQL errors reported.

| Exercise | Observed result | Status |
| --- | --- | --- |
| 1.1 | school_management created and selected | PASS |
| 1.2 | attendance, courses and student tables created | PASS |
| 2.1 | Three courses inserted, credits 15, 10 and 20 | PASS |
| 2.2 | Java Programming increased from 15 to 20 credits; one row changed | PASS |
| 2.3 | Web Development removed; two courses remain | PASS |
| 3.1 | Five students returned | PASS |
| 3.2 | JAVA-A returned John, Julia and Noah | PASS |
| 3.3 | J% returned John and Julia | PASS |
| 4.1 | INNER JOIN returned eight rows | PASS |
| 4.2 | LEFT JOIN returned nine rows, including Noah with NULL attendance | PASS |
| 5.1 | Total student count: 5 | PASS |
| 5.2 | Present: 5; Absent: 3 | PASS |
| 5.3 | Present days: John 2, Julia 1, Emma 1, Omar 1, Noah 0 | PASS |

## Final acceptance query

```sql
USE school_management;
SELECT
    (SELECT COUNT(*) FROM courses) AS courses,
    (SELECT COUNT(*) FROM student) AS students,
    (SELECT COUNT(*) FROM attendance) AS attendance_records,
    (SELECT COUNT(*) FROM attendance WHERE status = 'Present') AS present,
    (SELECT COUNT(*) FROM attendance WHERE status = 'Absent') AS absent;
```

| courses | students | attendance_records | present | absent |
| ---: | ---: | ---: | ---: | ---: |
| 2 | 5 | 8 | 5 | 3 |

The report records the supplied local execution log, not a CI run. It covers the workshop's normal execution path and the unmatched-student join case, not exhaustive constraint or failure-mode testing.
