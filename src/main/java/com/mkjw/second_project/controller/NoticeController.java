package com.mkjw.second_project.controller;

import com.mkjw.second_project.domain.Notice;
import com.mkjw.second_project.service.NoticeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoticeController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private NoticeServiceImpl noticeService;

    //학생이 속한 모든 수업의 게시글을 반환한다.
    @RequestMapping(value = "/notices/{studentId}", method = RequestMethod.GET)
    public ResponseEntity<List<Notice>> getAllNoticesBelongToStudent(@PathVariable("studentId") String studentId) {
        logger.info("getAllNoticesBelongToStudent", studentId);

        List<Notice> notices = noticeService.getAllNoticesBelongToStudent(studentId);

        return new ResponseEntity<>(notices, HttpStatus.OK);
    }

    //학생이 속한 특정 년도의 모든 수업의 게시글을 반환한다.
    //year 대신 all 옵션을 줘서 모든 년도의 게시글을 얻어올 수도 있어야 할 것 같다.
    @RequestMapping(value = "/notices/{studentId}/{year}", method = RequestMethod.GET)
    public List<Notice> getAllNoticesBelongToStudentInYear(@PathVariable("studentId") String studentId, @PathVariable("year") long year) {
        logger.info("getAllNoticesBelongToStudentInYear", studentId, year);

        //특정 년도에 속한 수업 리스트를 받아온다.

        //해당 수업 중 학생이 속한 수업을 골라낸다.

        //그 수업에 모든 게시글을 얻어온다.
        return null;
    }

    //게시글을 올린다.
}
