package com.example.demo.controller;

import com.example.demo.converter.UserConverter;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.models.User;
import com.example.demo.service.ServiceUser;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
public class UserController {

  private ServiceUser service;
  private UserConverter converter = new UserConverter();

  public UserController(ServiceUser service) {
    this.service = service;
  }

  @GetMapping
  public List<UserDto> getAll() {
    Comparator<User> sortById = (Comparator.comparingInt(User::getId));
    return service.findAll().stream().sorted(sortById).map(user -> converter.convert(user)).collect(Collectors.toList());
  }

  @GetMapping("{id}")
  public UserDto getOne(@PathVariable String id) {
    return converter.convert(getUser(Integer.parseInt(id)));
  }

  private User getUser(int id) {
    User user = service.find(id);
    if (user == null) {
      throw new NotFoundException();
    } else {
      return user;
    }
  }

  @PostMapping
  public UserDto create(@RequestBody User user) {
    return converter.convert(service.save(user));
  }

  @PutMapping("{id}")
  public UserDto update(@PathVariable String id, @RequestBody User user) {
    User userFromDb = getUser(Integer.parseInt(id));

    if (user.getAge() != 0) {
      userFromDb.setAge(user.getAge());
    }
    if (user.getName() != null) {
      userFromDb.setName(user.getName());
    }
    service.save(userFromDb);

    return converter.convert(userFromDb);
  }

  @DeleteMapping("{id}")
  public String delete(@PathVariable String id) {
    User user = getUser(Integer.parseInt(id));
    service.delete(user);
    return "User: " + user.toString() + " has been deleted from db";
  }

}
