package com.mkjw.second_project.repository;

import com.mkjw.second_project.domain.TakeRelationship;
import com.mkjw.second_project.domain.TakeRelationshipId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface TakeRelationshipRepository extends JpaRepository<TakeRelationship, TakeRelationshipId> {

    @Query(value = "SELECT course_id FROM take_relationship WHERE student_id = :student_id", nativeQuery = true)
    Collection<String> findAllCoursesTakenByStudentId(@Param("student_id") String student_id);

    @Query(value = "SELECT student_id FROM take_relationship WHERE course_id = :course_id", nativeQuery = true)
    Collection<String> findAllStudentsTakeCourse(@Param("course_id") String course_id);
}
