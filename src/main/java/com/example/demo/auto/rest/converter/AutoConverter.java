package com.example.demo.auto.rest.converter;

import com.example.demo.auto.rest.model.Auto;

public interface AutoConverter {

    Auto convert(com.example.demo.auto.persistence.entity.Auto auto);
}
