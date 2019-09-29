package com.mkjw.second_project.controller;

import com.mkjw.second_project.registration.OnRegistrationCompleteEvent;
import com.mkjw.second_project.token.VerificationToken;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Calendar;
import java.util.Locale;

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

    @ResponseBody
    @RequestMapping(value = "/user/email/exists", method = RequestMethod.GET)
    public boolean checkEmailExists(final HttpServletRequest request, @RequestParam("email") String email) {
        return userService.emailExists(email);
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(@ModelAttribute @Valid final UserDto userDto, BindingResult result, final HttpServletRequest request, Errors errors) {

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

    @RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
    public String confirmRegistration(WebRequest request, Model model, @RequestParam("token") String token) {

        Locale locale = request.getLocale();

        VerificationToken verificationToken = userService.getVerificationToken(token);

        if (verificationToken == null) {
            String message = "verificationToken is not found";
            model.addAttribute("message", message);

            return "redirect:/badUser.html?lang=" + locale.getLanguage();
        }

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();

        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            String messageValue = "verificationToken is expired";
            model.addAttribute("message", messageValue);

            return "redirect:/badUser.html?lang=" + locale.getLanguage();
        }

        user.setEnabled(true);
        userService.saveRegisteredUser(user);

        return "redirect:/login.html?lang=" + request.getLocale().getLanguage();
    }

}
