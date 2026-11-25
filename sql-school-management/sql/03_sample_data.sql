USE school_management;

-- Fictional supporting data for exercises 3-5.
-- Run once on the newly created tables.
INSERT INTO student (id, name, class_group) VALUES
    (1, 'John Andersson', 'JAVA-A'),
    (2, 'Julia Lind', 'JAVA-A'),
    (3, 'Emma Berg', 'JAVA-B'),
    (4, 'Omar Saleh', 'JAVA-B'),
    (5, 'Noah Holm', 'JAVA-A');

INSERT INTO attendance (student_id, attendance_date, status) VALUES
    (1, '2026-11-23', 'Present'),
    (1, '2026-11-24', 'Present'),
    (1, '2026-11-25', 'Absent'),
    (2, '2026-11-23', 'Absent'),
    (2, '2026-11-24', 'Present'),
    (3, '2026-11-23', 'Present'),
    (4, '2026-11-23', 'Present'),
    (4, '2026-11-24', 'Absent');

-- Noah deliberately has no attendance records.
