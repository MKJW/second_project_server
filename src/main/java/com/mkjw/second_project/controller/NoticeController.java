package com.mkjw.second_project.controller;

import com.mkjw.second_project.domain.Notice;
import com.mkjw.second_project.repository.NoticeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
public class NoticeController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private NoticeRepository noticeRepository;

    @RequestMapping(value = "/notices", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Notice> noticeList() {
        return noticeRepository.findAll();
    }

    @RequestMapping(value = "/notices/{id}", method = RequestMethod.GET)
    public Notice notice(@PathVariable("id") long id) {
        return noticeRepository.findById(id).orElse(null);
    }

    @RequestMapping(value = "/notices/{userId}", method = RequestMethod.GET)
    public Collection<Notice> userNotices(@PathVariable("userId") String userId) {
        return Collections.emptyList();
    }

    @RequestMapping(value = "/notices", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void postNotice(@RequestBody Notice notice) {
        logger.error("postNotice with ", notice);
    }
}
