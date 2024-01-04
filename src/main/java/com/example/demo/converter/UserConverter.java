package com.example.demo.converter;

import com.example.demo.dto.UserDto;
import com.example.demo.models.User;

public class UserConverter {

  public UserDto convert(User user) {
    return new UserDto(user.getName(), user.getAge());
  }
}
