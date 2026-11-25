USE school_management;

-- Exercise 3.1: Select all columns from student.
SELECT *
FROM student
ORDER BY id;

-- Exercise 3.2: Select students from a particular class group.
SELECT *
FROM student
WHERE class_group = 'JAVA-A'
ORDER BY id;

-- Exercise 3.3: Select students whose names begin with J.
SELECT *
FROM student
WHERE name LIKE 'J%'
ORDER BY id;
