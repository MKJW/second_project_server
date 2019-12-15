package com.mkjw.second_project.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/*
학생이 듣고 있는 수업에 관한 정보를 저장한다.

즉 학생 - 수업 짝을 저장하고 있는 테이블
 */
@Data
@Entity
@IdClass(TakeRelationshipId.class)
public class TakeRelationship {
    @Id
    private String student_id;

    @Id
    private String course_id;
}
