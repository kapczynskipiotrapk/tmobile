package org.example.config;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.example.steps",
        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumber-report.html",
        },
        monochrome = true
)
public class TestRunner {
}
