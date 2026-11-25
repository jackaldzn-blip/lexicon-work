USE school_management;

-- Exercise 2.1: Insert three courses.
INSERT INTO courses (course_name, credits) VALUES
    ('Java Programming', 15),
    ('SQL Basics', 10),
    ('Web Development', 20);

SELECT * FROM courses ORDER BY id;

-- Exercise 2.2: Increase Java Programming credits from 15 to 20.
-- Look up the generated ID and use the primary key in the UPDATE.
SET @java_id = (
    SELECT id FROM courses
    WHERE course_name = 'Java Programming'
    ORDER BY id LIMIT 1
);
UPDATE courses
SET credits = 20
WHERE id = @java_id;

SELECT * FROM courses ORDER BY id;

-- Exercise 2.3: Delete one course by its ID.
-- Web Development is the chosen example.
SET @course_to_delete = (
    SELECT id FROM courses
    WHERE course_name = 'Web Development'
    ORDER BY id LIMIT 1
);
DELETE FROM courses
WHERE id = @course_to_delete;

SELECT * FROM courses ORDER BY id;
