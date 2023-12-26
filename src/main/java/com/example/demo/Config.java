package com.example.demo;

import com.example.demo.dao.AutoDao;
import com.example.demo.dao.UserDao;
import com.example.demo.services.AutoService;
import com.example.demo.services.UserServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  @Bean
  public UserServices initUserServices(UserDao userDao) {
    return new UserServices(userDao);
  }

  @Bean
  public AutoService initAutoService(AutoDao autoDao) {return new AutoService(autoDao);}
}


