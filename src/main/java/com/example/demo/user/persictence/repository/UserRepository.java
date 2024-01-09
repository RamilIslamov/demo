package com.example.demo.user.persictence.repository;

import com.example.demo.user.persictence.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
