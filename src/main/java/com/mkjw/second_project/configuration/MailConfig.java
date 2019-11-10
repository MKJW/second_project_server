package com.mkjw.second_project.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    private static final String MAIL_DEBUG = "mail.debug";
    private static final String MAIL_SMTP_AUTH = "spring.mail.properties.mail.smtps.auth";
    private static final String MAIL_SMTP_STARTTLS_ENABLE = "spring.mail.properties.mail.smtps.starttls.enable";
    private static final String HOST = "spring.mail.host";
    private static final String PROTOCOL = "spring.mail.protocol";
    private static final String PORT = "spring.mail.port";
    private static final String USERNAME = "spring.mail.username";
    private static final String PASSWORD = "spring.mail.password";
    private static final String DEFAULT_ENCODING = "defaultEncoding";

    @Autowired
    private Environment env;

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty(HOST));
        mailSender.setProtocol(env.getProperty(PROTOCOL));
        mailSender.setPort(env.getProperty(PORT, Integer.class));
        mailSender.setUsername(env.getProperty(USERNAME));
        mailSender.setPassword(env.getProperty(PASSWORD));
        mailSender.setDefaultEncoding(env.getProperty(DEFAULT_ENCODING));

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtps.starttls.enable", env.getProperty(MAIL_SMTP_STARTTLS_ENABLE));
        properties.put("mail.smtps.auth", env.getProperty(MAIL_SMTP_AUTH));
        properties.put(MAIL_DEBUG, true);
        mailSender.setJavaMailProperties(properties);

        return mailSender;
    }
}
