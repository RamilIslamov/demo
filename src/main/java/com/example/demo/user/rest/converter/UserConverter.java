package com.example.demo.user.rest.converter;

import com.example.demo.user.rest.model.User;

import java.util.List;

public interface UserConverter {

    User convert(com.example.demo.user.persistence.entity.User user);

    List<User> convert(List<com.example.demo.user.persistence.entity.User> user);

    com.example.demo.user.persistence.entity.User convert(User api);

}
