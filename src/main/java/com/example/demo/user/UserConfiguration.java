package com.example.demo.user;

import com.example.demo.user.persistence.repository.UserRepository;
import com.example.demo.user.rest.converter.UserConverter;
import com.example.demo.user.rest.converter.impl.UserConverterImpl;
import com.example.demo.user.service.UserService;
import com.example.demo.user.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public UserConverter initUserConverter() {
        return new UserConverterImpl();
    }

    @Bean
    public UserService initUserServices(final UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

}
