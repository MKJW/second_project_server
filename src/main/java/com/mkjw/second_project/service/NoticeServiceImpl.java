package com.mkjw.second_project.service;

import com.mkjw.second_project.entity.Course;
import com.mkjw.second_project.entity.Notice;
import com.mkjw.second_project.repository.CourseRepository;
import com.mkjw.second_project.repository.NoticeRepository;
import com.mkjw.second_project.repository.TakeRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TakeRelationshipRepository takeRelationshipRepository;

    @Override
    public List<Notice> getAllNoticesBelongToCourse(String courseId) {
        return (List<Notice>) noticeRepository.findAllByCourseId(courseId);
    }

    @Override
    public List<Notice> getAllNoticesBelongToStudent(String studentId) {
        List<String> courseIds = (List<String>) takeRelationshipRepository.findAllCoursesTakenByStudentId(studentId);

        List<Notice> notices = new ArrayList<>();
        for (String courseId : courseIds) {
            Optional<Course> course = courseRepository.findById(courseId);
            if (course.isPresent()) {
                notices.addAll(getAllNoticesBelongToCourse(course.get().getCourse_id()));
            }
        }

        return notices;
    }

}
