package com.mkjw.second_project.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Section {
    @Id
    private int section_id;

    private int course_id;

    private String teacher_id;

    private int number_of_student;
}
