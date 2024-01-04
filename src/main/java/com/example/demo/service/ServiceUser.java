package com.example.demo.service;

import com.example.demo.models.User;

import java.util.List;

public interface ServiceUser {

  List<User> findAll();

  User find(int id);

  User save(User user);

  void delete(User user);

}
