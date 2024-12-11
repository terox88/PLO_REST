package com.plo.restplo.cofiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class PloConfig {
    @Bean
    Random random() {
        return new Random();
    }
}
