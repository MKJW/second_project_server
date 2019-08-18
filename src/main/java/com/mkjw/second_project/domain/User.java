package com.mkjw.second_project.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
public class User {
    @Id
    private String user_id;

    private String school_id;

    private String type;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    @Builder
    public User(String userId, String schoolId, String type, String firstName, String lastName, String email, String phone) {
        this.user_id = userId;
        this.school_id = schoolId;
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}
