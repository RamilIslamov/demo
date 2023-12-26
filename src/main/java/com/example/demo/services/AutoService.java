package com.example.demo.services;

import com.example.demo.dao.AutoDao;
import com.example.demo.models.Auto;

public class AutoService {

  private AutoDao autoDao;

  public AutoService(AutoDao autoDao) {
    this.autoDao = autoDao;
  }

  public Auto find(int id) {
    return autoDao.findById(id).orElse(null);
  }

  public void save(Auto auto) {
    autoDao.save(auto);
  }

  public void delete(Auto auto) {
    autoDao.delete(auto);
  }
}
