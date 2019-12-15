package com.mkjw.second_project.service;

import com.mkjw.second_project.entity.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> getAllNoticesBelongToCourse(String courseId);
    List<Notice> getAllNoticesBelongToStudent(String studentId);
}
