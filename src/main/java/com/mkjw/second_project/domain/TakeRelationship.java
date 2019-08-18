package com.mkjw.second_project.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(TakeRelationshipId.class)
public class TakeRelationship {
    @Id
    private String student_id;

    @Id
    private String course_id;
}
