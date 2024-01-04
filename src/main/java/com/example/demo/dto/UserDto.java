package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

  private String name;
  private int age;

  @JsonCreator
  public UserDto(@JsonProperty("name") String name,
                 @JsonProperty("age") int age) {
    this.name = name;
    this.age = age;
  }
}
