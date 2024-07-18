package com.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@Configuration
public class ConditionalConfiguration {

    @Bean
    @ConditionalOnProperty(name = "conditional.bean.enabled", havingValue = "true")
    public String ThisIsMyFirstConditionalBean() {
        return "This is my first conditional bean";
    }
}