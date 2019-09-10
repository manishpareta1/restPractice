package com.rest.consumer.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigUtil {

    @Autowired
    Environment environment;

    public String getProperty(String pPropertyKey) {
        return environment.getProperty(pPropertyKey);
    }

    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }

    public String welcome() {
        return "Welcome to Rest Consumer Application";
    }
}