package com.mkjw.second_project.fcm;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.mkjw.second_project.fcm.model.PushNotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FCMService {

    Logger logger = LoggerFactory.getLogger(FCMService.class);

    public void sendMessageWithoutData() throws ExecutionException, InterruptedException {
        Message message = getPreconfiguredMessageBuilder(null).build();
        String response = sendAndGetResponse(message);
        logger.info("Sent message with data");
    }

    public void sendMessageToToken(PushNotificationRequest request) throws ExecutionException, InterruptedException {
        Message message = getPreconfiguredMessageToToken(request);
        String response = sendAndGetResponse(message);
        logger.info("Sent message to token. Device token: ");
    }

    private String sendAndGetResponse(Message message) throws ExecutionException, InterruptedException {
        return FirebaseMessaging.getInstance().sendAsync(message).get();
    }

    private Message getPreconfiguredMessageToToken(PushNotificationRequest request) {
        return getPreconfiguredMessageBuilder(request)
                .setToken(request.getToken())
                .build();
    }

    public Message.Builder getPreconfiguredMessageBuilder(PushNotificationRequest request) {
        return Message.builder()
                .setNotification(new Notification(request.getTitle(), request.getMessage()));
    }
}
