package com.younesnaja.bowlingapp;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/BowlingGameTestReport.html", "pretty"},
        features = {"src/test/resources"}
)
public class BowlingAppTest {
}
