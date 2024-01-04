package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.models.Auto;
import com.example.demo.service.ServiceAuto;
import com.example.demo.service.impl.AutoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("auto")
public class AutoController {

  private ServiceAuto service;

  public AutoController(ServiceAuto service) {
    this.service = service;
  }

  @GetMapping
  public List<Auto> getAll() {
    return service.findAll();
  }

  @GetMapping("{id}")
  public Auto getOne(@PathVariable String id) {
    return getAuto(id);
  }

  private Auto getAuto(String id) {
    Auto auto = service.find(Integer.parseInt(id));
    if (auto == null) {
      throw new NotFoundException();
    } else {
      return auto;
    }
  }

  @PostMapping
  public Auto create(@RequestBody Auto auto) {
    service.save(auto);
    return auto;
  }

  @PutMapping("{id}")
  public Auto update(@PathVariable String id, @RequestBody Auto auto) {
    Auto autoFromDb = getAuto(id);

    if (auto.getColor() != null) {
      autoFromDb.setColor(auto.getColor());
    }
    if (auto.getModel() != null) {
      autoFromDb.setModel(auto.getModel());
    }
    service.save(autoFromDb);

    return autoFromDb;
  }

  @DeleteMapping("{id}")
  public String delete(@PathVariable String id) {
    Auto auto = getAuto(id);
    service.delete(auto);
    return "Auto - " + auto + " has been deleted from db";
  }

}
