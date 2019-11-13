package com.mkjw.second_project;
import com.mkjw.second_project.domain.Notice;
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

                noticeRepository.save(notice);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SecondProjectApplication.class, args);
    }

}
