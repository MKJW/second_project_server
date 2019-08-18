package com.mkjw.second_project.controller;

import com.mkjw.second_project.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CourseController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TakeRelationshipRepository takeRelationshipRepository;

    @GetMapping("/courses/{school_id}/{grade}")
    public Collection<Course> courseList(@PathVariable("school_id") String schoolId, @PathVariable("grade") String grade) {
        return courseRepository.findAllCoursesBySchoolAndGrade(schoolId, grade);
    }

    @PostMapping("/courses/register")
    public HttpStatus registerCourse(@RequestParam("course_id") String course_id, @RequestParam("student_id") String student_id) {
        logger.error("course_id : " + course_id + " user_id : " + student_id);
        TakeRelationship relationship = new TakeRelationship();
        relationship.setCourse_id(course_id);
        relationship.setStudent_id(student_id);

        takeRelationshipRepository.save(relationship);
        return HttpStatus.OK;
    }
}
