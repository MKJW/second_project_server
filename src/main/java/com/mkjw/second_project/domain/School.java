package com.mkjw.second_project.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class School {
    @Id
    private String school_id;

    private String school_name;

    private String school_location;
}
