USE school_management;

-- Exercise 5.1: Count all students.
SELECT COUNT(*) AS total_students
FROM student;

-- Exercise 5.2: Count attendance records by status.
SELECT status, COUNT(*) AS total_records
FROM attendance
GROUP BY status
ORDER BY status;

-- Exercise 5.3: Count present days for each student, including zero.
-- The condition is in ON so students without present records remain.
-- COUNT(a.id) ignores NULLs introduced by LEFT JOIN.
SELECT s.name, COUNT(a.id) AS present_days
FROM student AS s
LEFT JOIN attendance AS a
    ON s.id = a.student_id AND a.status = 'Present'
GROUP BY s.id, s.name
ORDER BY s.id;
