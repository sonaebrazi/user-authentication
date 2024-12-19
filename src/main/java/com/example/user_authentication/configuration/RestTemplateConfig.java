package com.example.user_authentication.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate() {
        // Create and return RestTemplate instance to communicate with the User Registration Microservice
        return new RestTemplate();
    }
}
