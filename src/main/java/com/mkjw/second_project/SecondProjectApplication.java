package com.mkjw.second_project;
import com.mkjw.second_project.entity.Notice;
import com.mkjw.second_project.repository.NoticeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.util.Date;

@SpringBootApplication
public class SecondProjectApplication {

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeHeaders(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setMaxPayloadLength(100);
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setBeforeMessagePrefix("Before: ");
        loggingFilter.setBeforeMessageSuffix("");
        loggingFilter.setAfterMessagePrefix("After: ");
        loggingFilter.setAfterMessageSuffix("");

        return loggingFilter;
    }

    @Bean
    public CommandLineRunner generateNoticeData(NoticeRepository noticeRepository) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                Notice notice = new Notice();
                notice.setTitle("Title " + (i + 1));
                notice.setContent("Content " + (i + 1));
                notice.setCreatedDate(new Date());
                notice.setCourseId("INHA-001");

                //TODO below code is temporary for test and should be removed later
                if (i < 3) {
                    notice.setCategory("국어");
                } else if (i < 6) {
                    notice.setCategory("수학");
                } else {
                    notice.setCategory("영어");
                }

                noticeRepository.save(notice);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SecondProjectApplication.class, args);
    }

}
