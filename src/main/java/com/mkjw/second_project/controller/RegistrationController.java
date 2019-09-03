package com.mkjw.second_project.controller;

import com.mkjw.second_project.registration.OnRegistrationCompleteEvent;
import com.mkjw.second_project.user.IUserService;
import com.mkjw.second_project.persistence.User;
import com.mkjw.second_project.user.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegistrationForm(final HttpServletRequest request, final Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);

        return "registration";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid final UserDto userDto, BindingResult result, final HttpServletRequest request, Errors errors) {

        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", userDto);
        }

        LOGGER.debug("Registering user account with information: {}", userDto);

        final User registered = userService.registerNewUserAccount(userDto);

        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }

        try {
            String appUrl = request.getContextPath();
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), appUrl));
        } catch (final Exception e) {
            return new ModelAndView("emailError", "user", userDto);
        }

        return new ModelAndView("successRegister", "user", userDto);
    }

}
