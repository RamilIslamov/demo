package com.example.demo.user.rest.converter.impl;

import com.example.demo.user.rest.converter.UserConverter;
import com.example.demo.user.rest.model.User;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class UserConverterImpl implements UserConverter {

    public User convert(com.example.demo.user.persistence.entity.User entity) {
        return new User(entity.getName(), entity.getAge());
    }

    public List<User> convert(List<com.example.demo.user.persistence.entity.User> entities) {
        return entities.stream()
                    .map(this::convert)
                    .collect(toList());
    }


    public com.example.demo.user.persistence.entity.User convert(User api) {
        return new com.example.demo.user.persistence.entity.User(api.getName(), api.getAge());
    }


}
