package com.example.demo.service.impl;

import com.example.demo.models.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.ServiceUser;

import java.util.ArrayList;
import java.util.List;

public class UserService implements ServiceUser {

  private UserRepo userRepo;

  public UserService(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  public List<User> findAll() {
    List<User> users = new ArrayList<>();
    userRepo.findAll().forEach((user) -> users.add(user));
    return users;
  }

  public User find(int id) {
    return userRepo.findById(id).orElse(null);
  }

  public User save(User user) {
    return userRepo.save(user);
  }

  public void delete(User user) {
    userRepo.delete(user);
  }

}
