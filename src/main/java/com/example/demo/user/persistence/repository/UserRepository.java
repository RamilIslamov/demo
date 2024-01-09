package com.example.demo.user.persistence.repository;

import com.example.demo.user.persistence.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT t FROM User t ORDER BY t.id")
    List<User> findAllOrderById();
}
