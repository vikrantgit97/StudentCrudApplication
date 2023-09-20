package com.crudapp.service.impl;

import com.crudapp.entity.User;
import com.crudapp.repo.UserRepository;
import com.crudapp.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Vikrant on 18-09-2023
 * @Project StudentRegistrationApplication
 */

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long saveUser(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public void updateUserPwd(String pwd, Integer userId) {

    }

}
