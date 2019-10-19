package com.mkjw.second_project.service;

import com.mkjw.second_project.fcm.FCMService;
import com.mkjw.second_project.fcm.model.PushNotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class PushNotificationService {

    private Logger logger = LoggerFactory.getLogger(PushNotificationService.class);

    private FCMService fcmService;

    public PushNotificationService(FCMService fcmService) {
        this.fcmService = fcmService;
    }

    public void sendSamplePushNotification() {
        try {
            fcmService.sendMessageWithoutData();
        } catch (ExecutionException | InterruptedException e) {
            logger.error(e.getMessage());
        }
    }

    public void sendPushNotificationToToken(String token) {
        try {
            PushNotificationRequest request = new PushNotificationRequest("title", "message", "topic");
            request.setToken(token);
            fcmService.sendMessageToToken(request);
        } catch (ExecutionException | InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
