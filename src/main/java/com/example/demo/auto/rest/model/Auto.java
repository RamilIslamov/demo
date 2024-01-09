package com.example.demo.auto.rest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Auto {

    private final String color;
    private final String model;

    @JsonCreator
    public Auto(@JsonProperty("color") String color,
                @JsonProperty("model") String model) {
        this.color = color;
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

}
