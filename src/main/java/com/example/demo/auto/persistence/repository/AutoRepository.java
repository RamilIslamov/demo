package com.example.demo.auto.persistence.repository;

import com.example.demo.auto.persistence.entity.Auto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AutoRepository extends CrudRepository<Auto, Integer> {

    List<Auto> findAllByIdNotNullOrderById();

}
