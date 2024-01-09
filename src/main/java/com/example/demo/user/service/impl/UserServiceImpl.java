package com.example.demo.user.service.impl;

import com.example.demo.user.persistence.entity.User;
import com.example.demo.user.persistence.repository.UserRepository;
import com.example.demo.user.service.UserService;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = requireNonNull(userRepository, "userRepository is required to be not null.");
    }

    public List<User> findAll() {
        return userRepository.findAllOrderById();
    }

    public User find(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

}
