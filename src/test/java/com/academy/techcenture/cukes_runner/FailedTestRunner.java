package com.academy.techcenture.cukes_runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// Runs only when the test failed

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "com/academy/techcenture/step_definitions"
)
public class FailedTestRunner {

}
