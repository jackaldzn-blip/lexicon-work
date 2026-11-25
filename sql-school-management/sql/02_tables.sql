USE school_management;

-- Exercise 1.2: Create the courses table.
CREATE TABLE courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    credits INT NOT NULL
) ENGINE=InnoDB;

-- Supporting tables for exercises 3-5.
-- These are proposed schemas because the lecture definitions were not supplied.
CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    class_group VARCHAR(50) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE attendance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    attendance_date DATE NOT NULL,
    status ENUM('Present', 'Absent') NOT NULL,
    CONSTRAINT fk_attendance_student
        FOREIGN KEY (student_id) REFERENCES student(id),
    CONSTRAINT uq_student_attendance_date
        UNIQUE (student_id, attendance_date)
) ENGINE=InnoDB;
