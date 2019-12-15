package com.mkjw.second_project.repository;

import com.mkjw.second_project.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    //TODO 커스텀 쿼리를 좀 더 잘 작성하는 방법을 찾아보자.
    @Query(value = "SELECT * FROM notice WHERE course_id = :course_id", nativeQuery = true)
    Collection<Notice> findAllByCourseId(@Param("course_id") String course_id);
}