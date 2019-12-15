package com.mkjw.second_project.repository;

import com.mkjw.second_project.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
