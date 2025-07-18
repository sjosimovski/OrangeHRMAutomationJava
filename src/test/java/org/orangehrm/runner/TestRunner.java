package org.orangehrm.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.orangehrm.stepdefinition", "org.orangehrm.hooks"},
        plugin = {"pretty", "summary"},
        monochrome = true
)
public class TestRunner {
}

