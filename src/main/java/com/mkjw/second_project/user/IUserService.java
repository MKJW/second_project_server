package com.mkjw.second_project.user;

import com.mkjw.second_project.exception.UserAlreadyExistException;
import com.mkjw.second_project.persistence.User;

public interface IUserService {
    User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException;
}
