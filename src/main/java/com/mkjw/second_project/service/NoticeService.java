package com.mkjw.second_project.service;

import com.mkjw.second_project.domain.Course;
import com.mkjw.second_project.domain.Notice;
import com.mkjw.second_project.domain.Student;
import com.mkjw.second_project.repository.CourseRepository;
import com.mkjw.second_project.repository.NoticeRepository;
import com.mkjw.second_project.repository.TakeRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TakeRelationshipRepository takeRelationshipRepository;

    //studentID 가 속한 모든 수업의 게시글을 얻어온다.
    public List<Notice>  getAllNoticesBelongToStudent(String studentId) {

        Student student = studentService.findStudentById(studentId);

        if (student == null) {
            return null;
        }

        //1. studentID 가 속한 모든 수업 아이디를 가져온다.
        //TakeRelationship 을 이용
        Collection<String> courseIds = takeRelationshipRepository.findAllCoursesTakenByStudentId(studentId);

        List<Course> courses = new ArrayList<>();
        for (String courseId : courseIds) {
            Course course = courseRepository.getOne(courseId);
            courses.add(course);
        }

        System.out.println("course size is " + courses.size());

        //2. 각 수업의 게시글 리스트를 얻어온다.
        List<Notice> notices = new ArrayList<>();
        for (Course course : courses) {
            notices.addAll(noticeRepository.findByCourseId(course.getCourse_id()));
        }

        return notices;
    }
}
