package com.mkjw.second_project.service;

import com.mkjw.second_project.exception.UserAlreadyExistException;
import com.mkjw.second_project.entity.User;
import com.mkjw.second_project.entity.VerificationToken;
import com.mkjw.second_project.dto.UserDto;

public interface IUserService {
    User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException;

    void saveRegisteredUser(User user);

    void createVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String verificationToken);

    boolean emailExists(String email);
}
