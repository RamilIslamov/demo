package com.example.demo.user.rest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import static java.util.Objects.requireNonNull;

public class User {

    private final String name;

    private final int age;

    @JsonCreator
    public User(@JsonProperty("name") String name,
                @JsonProperty("age") Integer age) {
        this.name = requireNonNull(name, "name is required");
        this.age = requireNonNull(age, "age is required");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
