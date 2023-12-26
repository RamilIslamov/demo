package com.example.demo.services;

import com.example.demo.dao.UserDao;
import com.example.demo.models.User;

public class UserServices {

  private UserDao usersDao;

  public UserServices(UserDao userDao) {
    this.usersDao = userDao;
  }

  public User findUser(int id) {
    return usersDao.findById(id).orElse(null);
  }

  public void saveUser(User user) {
    usersDao.save(user);
  }

  public void deleteUser(User user) {
    usersDao.delete(user);
  }

}
