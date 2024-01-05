package com.example.demo.service.impl;

import com.example.demo.models.Auto;
import com.example.demo.repo.AutoRepo;
import com.example.demo.service.AutoService;

import java.util.ArrayList;
import java.util.List;

public class AutoServiceImpl implements AutoService {

    private final AutoRepo autoRepo;

    public AutoServiceImpl(AutoRepo autoRepo) {
        this.autoRepo = autoRepo;
    }

    public List<Auto> findAll() {
        List<Auto> autos = new ArrayList<>();
        //TODO:вот это у тебя из JS осталось колбэки эти. есть готовый функционал для подобного - посмотри в юзерсенрвисе
        autoRepo.findAll().forEach(autos::add);
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
