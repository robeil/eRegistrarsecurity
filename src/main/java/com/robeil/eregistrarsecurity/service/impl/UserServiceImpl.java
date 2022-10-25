package com.robeil.eregistrarsecurity.service.impl;

import com.robeil.eregistrarsecurity.model.User;
import com.robeil.eregistrarsecurity.repository.RoleRepository;
import com.robeil.eregistrarsecurity.repository.UserRepository;
import com.robeil.eregistrarsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(Sort.by("firstName"));
    }

    @Override
    public User saveUser(User user) {
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
