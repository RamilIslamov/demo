package com.example.demo.user.service;

import com.example.demo.user.persistence.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User find(int id);

    User save(User user);

    void delete(User user);

}
