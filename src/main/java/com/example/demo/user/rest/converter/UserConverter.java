package com.example.demo.user.rest.converter;

import com.example.demo.user.rest.model.User;

public interface UserConverter {

    User convert(com.example.demo.user.persistence.entity.User user);

}
