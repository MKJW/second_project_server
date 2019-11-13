INSERT INTO course (course_id, course_name, school_id, grade, year) VALUES ('INHA-001', 'MATH', 'INHA', '1', '2019');
INSERT INTO course (course_id, course_name, school_id, grade, year) VALUES ('INHA-002', 'CS', 'INHA', '1', '2019');
INSERT INTO course (course_id, course_name, school_id, grade, year) VALUES ('INHA-003', 'ART', 'INHA', '2', '2019');

INSERT INTO student (user_id, grade) VALUES ('chomk', '1');
INSERT INTO student (user_id, grade) VALUES ('qwebnm', '1');

INSERT INTO take_relationship (student_id, course_id) VALUES ('chomk', 'INHA-001');
INSERT INTO take_relationship (student_id, course_id) VALUES ('qwebnm', 'INHA-002');