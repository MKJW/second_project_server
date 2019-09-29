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
@PropertySource("classpath:email.properties")
public class MailConfig {

    private static final String MAIL_DEBUG = "mail.debug";
    private static final String MAIL_SMTP_STARTTLS_REQUIRED = "mail.smtp.starttls.required";
    private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
    private static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    private static final String HOST = "host";
    private static final String PROTOCOL = "protocol";
    private static final String PORT = "port";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
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
        properties.put(MAIL_SMTP_STARTTLS_REQUIRED, env.getProperty(MAIL_SMTP_STARTTLS_REQUIRED));
        properties.put(MAIL_SMTP_STARTTLS_ENABLE, env.getProperty(MAIL_SMTP_STARTTLS_ENABLE));
        properties.put(MAIL_SMTP_AUTH, env.getProperty(MAIL_SMTP_AUTH));
        properties.put(MAIL_DEBUG, true);
        mailSender.setJavaMailProperties(properties);

        return mailSender;
    }
}
