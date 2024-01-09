package com.example.demo.auto.service.impl;

import com.example.demo.auto.persistence.entity.Auto;
import com.example.demo.auto.persistence.repository.AutoRepository;
import com.example.demo.auto.service.AutoService;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class AutoServiceImpl implements AutoService {

    private final AutoRepository autoRepository;

    public AutoServiceImpl(AutoRepository autoRepository) {
        this.autoRepository = requireNonNull(autoRepository, "autoRepository is required to be not null.");
    }

    @Override
    public List<Auto> findAll() {
        return autoRepository.findAllByIdNotNullOrderById();
    }

    @Override
    public Auto find(int id) {
        return autoRepository.findById(id).orElse(null);
    }

    @Override
    public Auto save(Auto auto) {
        return autoRepository.save(auto);
    }

    @Override
    public void delete(Auto auto) {
        autoRepository.delete(auto);
    }
}
