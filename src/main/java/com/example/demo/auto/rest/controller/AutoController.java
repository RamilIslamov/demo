package com.example.demo.auto.rest.controller;

import com.example.demo.auto.rest.converter.AutoConverter;
import com.example.demo.auto.rest.model.Auto;
import com.example.demo.auto.service.AutoService;
import com.example.demo.common.exception.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("auto")
public class AutoController {

    private final AutoService autoService;
    private final AutoConverter autoConverter;

    public AutoController(AutoService autoService, AutoConverter autoConverter) {
        this.autoService = requireNonNull(autoService, "autoService is required to be not null.");
        this.autoConverter = requireNonNull(autoConverter, "autoConverter is required to be not null.");
    }

    @GetMapping
    public List<Auto> getAll() {

        return autoService.findAll()
                          .stream()
                          .map(autoConverter::convert)
                          .collect(toList());
    }

    @GetMapping("{id}")
    public Auto getOne(@PathVariable String id) {
        return autoConverter.convert(getAuto(Integer.parseInt(id)));
    }

    private com.example.demo.auto.persistence.entity.Auto getAuto(int id) {
        com.example.demo.auto.persistence.entity.Auto auto = autoService.find(id);
        if (auto == null) {
            throw new NotFoundException();
        } else {
            return auto;
        }
    }

    @PostMapping
    public Auto create(@RequestBody com.example.demo.auto.persistence.entity.Auto auto) {
        return autoConverter.convert(autoService.save(auto));
    }

    @PutMapping("{id}")
    public Auto update(@PathVariable String id, @RequestBody com.example.demo.auto.persistence.entity.Auto auto) {
        com.example.demo.auto.persistence.entity.Auto autoFromDb = getAuto(Integer.parseInt(id));

        if (auto.getColor() != null) {
            autoFromDb.setColor(auto.getColor());
        }
        if (auto.getModel() != null) {
            autoFromDb.setColor(auto.getModel());
        }
        autoService.save(autoFromDb);

        return autoConverter.convert(autoFromDb);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable String id) {
        com.example.demo.auto.persistence.entity.Auto auto = getAuto(Integer.parseInt(id));
        autoService.delete(auto);
        return "Auto: " + auto + " has been deleted from db";
    }
}
