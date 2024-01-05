package com.example.demo.user.service.impl;

import com.example.demo.user.persictence.entity.User;
import com.example.demo.user.persictence.repository.UserRepository;
import com.example.demo.user.service.UserService;

import java.util.List;

import static java.util.Objects.requireNonNull;
import static org.apache.commons.collections4.IteratorUtils.toList;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = requireNonNull(userRepository, "userRepository is required to be not null.");
    }

    public List<User> findAll() {
        return toList(userRepository.findAll().iterator());
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
