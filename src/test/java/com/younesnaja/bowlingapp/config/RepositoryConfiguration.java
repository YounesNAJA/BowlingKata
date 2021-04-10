package com.younesnaja.bowlingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RepositoryConfiguration {
    @Bean
    @Scope("cucumber-glue")
    public InMemoryBowlingGameContainer inMemoryBowlingGame() {
        return new InMemoryBowlingGameContainer();
    }
}
