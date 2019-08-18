package com.mkjw.second_project.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Course {
    @Id
    private String course_id;

    private String course_name;

    private String school_id;

    private String grade;
}
