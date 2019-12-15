package com.mkjw.second_project.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Student {
    @Id
    private String user_id;

    private String grade;
}
