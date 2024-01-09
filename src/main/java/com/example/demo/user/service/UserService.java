package com.example.demo.user.service;

import com.example.demo.user.persistence.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Integer id);

    User getById(Integer id);

    Boolean existById(Integer id);

    User getByIdOrElseThrow(Integer id);

    User save(User user);

    User upsert(Integer id, User user);

    void delete(User user);

}
