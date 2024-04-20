package com.TheGuardianNews.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "src/test/resources/features/stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-report.html"})
public class NewsValidationTest {

}
