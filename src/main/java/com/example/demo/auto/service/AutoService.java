package com.example.demo.auto.service;

import com.example.demo.auto.persistence.entity.Auto;

import java.util.List;

public interface AutoService {

    List<Auto> findAll();

    Auto find(int id);

    Auto save(Auto auto);

    void delete(Auto auto);
}
