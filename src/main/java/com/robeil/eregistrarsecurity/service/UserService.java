package com.robeil.eregistrarsecurity.service;

import com.robeil.eregistrarsecurity.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User saveUser(User user);

    User getUserById(Integer userId);
}
