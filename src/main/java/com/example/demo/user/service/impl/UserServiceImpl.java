package com.example.demo.user.service.impl;

import com.example.demo.common.exception.NotFoundException;
import com.example.demo.user.persistence.entity.User;
import com.example.demo.user.persistence.repository.UserRepository;
import com.example.demo.user.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = requireNonNull(userRepository, "userRepository is required to be not null.");
    }

    public List<User> findAll() {
        return userRepository.findAllOrderById();
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public User getById(Integer id) {
        return findById(id).orElse(null);
    }

    public Boolean existById(Integer id) {
        return findById(id).isPresent();
    }

    public User getByIdOrElseThrow(Integer id) {
        return findById(id).orElseThrow(() -> new NotFoundException("хуй тебе а не ентити"));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User upsert(Integer id, User user) {
        User existedUser = getById(id);

        if (null == existedUser) {
            return save(user);
        } else {
            existedUser.setAge(user.getAge());
            existedUser.setName(user.getName());
            return existedUser;
        }
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

}
