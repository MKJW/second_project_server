package com.mkjw.second_project.entity;

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

    //TODO 몇 년도 (몇 학기?) 에 속한 수업인지를 저장해야 한다. 어떤 형식으로 저장하는 것이 좋을까
    private String year;
}
