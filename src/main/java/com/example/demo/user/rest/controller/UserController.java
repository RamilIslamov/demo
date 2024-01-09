package com.example.demo.user.rest.controller;

import com.example.demo.user.rest.converter.UserConverter;
import com.example.demo.user.rest.model.User;
import com.example.demo.user.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    private final UserConverter userConverter;

    public UserController(UserService userService, UserConverter userConverter) {
        this.userService = requireNonNull(userService, "userService is required to be not null.");
        this.userConverter = requireNonNull(userConverter, "userConverter is required to be not null.");
    }

    @GetMapping
    public List<User> getAll() {
        return userConverter.convert(userService.findAll());
    }

    @GetMapping("{id}")
    public User getOne(@PathVariable Integer id) {
        requireNonNull(id, "id is required to be not null.");
        return userConverter.convert(userService.getById(id));
    }

    @PostMapping
    public User create(@RequestBody com.example.demo.user.persistence.entity.User user) {
        return userConverter.convert(userService.save(user));
    }

    @PutMapping("{id}")
    public User update(@PathVariable Integer id, @RequestBody User user) {
        com.example.demo.user.persistence.entity.User passedUser = userConverter.convert(user);
        return userConverter.convert(userService.upsert(id, passedUser));
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Integer id) {
        com.example.demo.user.persistence.entity.User user = userService.getById(id);
        if (null == user) {
            return "Нет такого юзера с айди = " + id;
        }
        userService.delete(user);
        return "User: " + user + " has been deleted from db";
    }

}
