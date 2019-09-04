package com.mkjw.second_project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailSenderTest {

    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void sendSimpleMessageTest() {
        String to = "qwebnm7788@naver.com";
        String subject = "MailSenderTest";
        String text = "This is sent from test code in second_project";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }
}
