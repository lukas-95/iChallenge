package com.iChallenge.person.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PessoaConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
