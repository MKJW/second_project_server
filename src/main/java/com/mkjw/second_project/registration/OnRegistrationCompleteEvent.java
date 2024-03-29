package com.mkjw.second_project.registration;

import com.mkjw.second_project.entity.User;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

@Data
public class OnRegistrationCompleteEvent extends ApplicationEvent {

    private final String appUrl;
    private final Locale locale;
    private final User user;

    public OnRegistrationCompleteEvent(final User user, final Locale locale, final String appUrl) {
        super(user);

        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }

}
