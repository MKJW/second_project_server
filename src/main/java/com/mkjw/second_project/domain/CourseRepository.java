package com.mkjw.second_project.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface CourseRepository extends JpaRepository<Course, String> {
    @Query(value = "SELECT * FROM course WHERE school_id = :school_id AND grade = :grade", nativeQuery = true)
    Collection<Course> findAllCoursesBySchoolAndGrade(@Param("school_id") String school_id, @Param("grade") String grade);
}
