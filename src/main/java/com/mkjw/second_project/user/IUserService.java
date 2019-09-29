package com.mkjw.second_project.user;

import com.mkjw.second_project.exception.UserAlreadyExistException;
import com.mkjw.second_project.persistence.User;
import com.mkjw.second_project.token.VerificationToken;

public interface IUserService {
    User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException;

    void saveRegisteredUser(User user);

    void createVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String verificationToken);

    boolean emailExists(String email);
}
