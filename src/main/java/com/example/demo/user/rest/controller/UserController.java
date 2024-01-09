package com.example.demo.user.rest.controller;

import com.example.demo.common.exception.NotFoundException;
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
import static java.util.stream.Collectors.toList;

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
        return userService.findAll()
                          .stream()
                          .map(userConverter::convert)
                          .collect(toList());

    }

    @GetMapping("{id}")
    public User getOne(@PathVariable String id) {
        return userConverter.convert(getUser(Integer.parseInt(id)));
    }

    private com.example.demo.user.persistence.entity.User getUser(int id) {
        com.example.demo.user.persistence.entity.User user = userService.find(id);
        if (user == null) {
            throw new NotFoundException();
        } else {
            return user;
        }
    }

    @PostMapping
    public User create(@RequestBody com.example.demo.user.persistence.entity.User user) {
        return userConverter.convert(userService.save(user));
    }

    @PutMapping("{id}")
    public User update(@PathVariable String id, @RequestBody com.example.demo.user.persistence.entity.User user) {
        com.example.demo.user.persistence.entity.User userFromDb = getUser(Integer.parseInt(id));

        if (user.getAge() != 0) {
            userFromDb.setAge(user.getAge());
        }
        if (user.getName() != null) {
            userFromDb.setName(user.getName());
        }
        userService.save(userFromDb);

        return userConverter.convert(userFromDb);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable String id) {
        com.example.demo.user.persistence.entity.User user = getUser(Integer.parseInt(id));
        userService.delete(user);
        return "User: " + user + " has been deleted from db";
    }

}
