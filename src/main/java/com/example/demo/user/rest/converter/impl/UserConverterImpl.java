package com.example.demo.user.rest.converter.impl;

import com.example.demo.user.rest.converter.UserConverter;
import com.example.demo.user.rest.model.User;

public class UserConverterImpl implements UserConverter {

    public User convert(com.example.demo.user.persictence.entity.User user) {
        return new User(user.getName(), user.getAge());
    }

}
