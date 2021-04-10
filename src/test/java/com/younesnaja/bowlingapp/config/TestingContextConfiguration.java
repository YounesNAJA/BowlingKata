package com.younesnaja.bowlingapp.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = InMemoryBowlingGameContainer.class)
public class TestingContextConfiguration {
}
