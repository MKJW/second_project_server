package com.mkjw.second_project.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Student {
    @Id
    private String user_id;

    private String grade;
}
