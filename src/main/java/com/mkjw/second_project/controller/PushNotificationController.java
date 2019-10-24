package com.mkjw.second_project.controller;

import com.mkjw.second_project.service.PushNotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PushNotificationController {

    private PushNotificationService pushNotificationService;

    public PushNotificationController(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }

    @PostMapping("/fcm/test/notification")
    public ResponseEntity sendSampleNotification(@RequestParam("device-token") String token) {
        pushNotificationService.sendPushNotificationToToken(token);
        pushNotificationService.sendPushNotificationToToken(token);
        return new ResponseEntity(HttpStatus.OK);
    }
}
