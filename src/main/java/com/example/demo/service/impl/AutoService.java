package com.example.demo.service.impl;

import com.example.demo.models.Auto;
import com.example.demo.repo.AutoRepo;
import com.example.demo.service.ServiceAuto;

import java.util.ArrayList;
import java.util.List;

public class AutoService implements ServiceAuto {

  private AutoRepo autoRepo;

  public AutoService(AutoRepo autoRepo) {
    this.autoRepo = autoRepo;
  }

  public List<Auto> findAll() {
    List<Auto> autos = new ArrayList<>();
    autoRepo.findAll().forEach((auto) -> autos.add(auto));
    return autos;
  }

  public Auto find(int id) {
    return autoRepo.findById(id).orElse(null);
  }

  public Auto save(Auto auto) {
    return autoRepo.save(auto);
  }

  public void delete(Auto auto) {
    autoRepo.delete(auto);
  }
}
