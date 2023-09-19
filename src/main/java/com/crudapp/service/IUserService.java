package com.crudapp.service;

import com.crudapp.entity.User;

import java.util.Optional;

/**
 * @author Vikrant on 18-09-2023
 * @Project StudentRegistrationApplication
 */
public interface IUserService {

    Long saveUser(User user);

    Optional<User> findByUsername(String username);

    void updateUserPwd(String pwd,Integer userId);
}
