package com.mkjw.second_project.entity;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/*
TakeRelationShip 은 두 개의 쌍으로 이루어진 키를 사용한다.
따라서 키로 사용할 클래스를 새롭게
 */
@NoArgsConstructor
public class TakeRelationshipId implements Serializable {

    private String student_id;

    private String course_id;

    public TakeRelationshipId(String course_id, String student_id) {
        this.student_id = student_id;
        this.course_id = course_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TakeRelationshipId that = (TakeRelationshipId) o;
        return Objects.equals(student_id, that.student_id) &&
                Objects.equals(course_id, that.course_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, course_id);
    }
}
