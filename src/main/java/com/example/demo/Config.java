package com.example.demo;

import com.example.demo.repo.AutoRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.ServiceAuto;
import com.example.demo.service.ServiceUser;
import com.example.demo.service.impl.AutoService;
import com.example.demo.service.impl.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  @Bean
  public ServiceUser initUserServices(UserRepo userRepo) {
    return new UserService(userRepo);
  }

  @Bean
  public ServiceAuto initAutoService(AutoRepo autoRepo) {return new AutoService(autoRepo);}
}


