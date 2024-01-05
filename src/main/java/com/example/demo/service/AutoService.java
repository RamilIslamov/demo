package com.example.demo.service;

import com.example.demo.models.Auto;

import java.util.List;

public interface AutoService {

    List<Auto> findAll();

    Auto find(int id);

    Auto save(Auto auto);

    void delete(Auto auto);

}
