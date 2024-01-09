package com.example.demo.auto;

import com.example.demo.auto.persistence.repository.AutoRepository;
import com.example.demo.auto.rest.converter.AutoConverter;
import com.example.demo.auto.rest.converter.impl.AutoConverterImpl;
import com.example.demo.auto.service.AutoService;
import com.example.demo.auto.service.impl.AutoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoConfiguration {

    @Bean
    public AutoConverter initAutoConverter() {
        return new AutoConverterImpl();
    }

    @Bean
    public AutoService initAutoServices(final AutoRepository autoRepository) {
        return new AutoServiceImpl(autoRepository);
    }

}

