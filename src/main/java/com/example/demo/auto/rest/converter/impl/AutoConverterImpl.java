package com.example.demo.auto.rest.converter.impl;

import com.example.demo.auto.rest.converter.AutoConverter;
import com.example.demo.auto.rest.model.Auto;

public class AutoConverterImpl implements AutoConverter {

    @Override
    public Auto convert(com.example.demo.auto.persistence.entity.Auto auto) {
        return new Auto(auto.getColor(), auto.getModel());
    }
}
