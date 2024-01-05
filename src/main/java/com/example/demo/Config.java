package com.example.demo;

import com.example.demo.repo.AutoRepo;
import com.example.demo.service.AutoService;
import com.example.demo.service.impl.AutoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public AutoService initAutoService(AutoRepo autoRepo) {return new AutoServiceImpl(autoRepo);}

}


