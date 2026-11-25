USE school_management;

-- Exercise 4.1: Show students who have matching attendance records.
SELECT s.name, a.status, a.attendance_date
FROM student AS s
INNER JOIN attendance AS a ON s.id = a.student_id
ORDER BY s.id, a.attendance_date;

-- Exercise 4.2: Include students with no attendance records.
-- Their attendance status and date will be NULL.
SELECT s.name, a.status, a.attendance_date
FROM student AS s
LEFT JOIN attendance AS a ON s.id = a.student_id
ORDER BY s.id, a.attendance_date;
