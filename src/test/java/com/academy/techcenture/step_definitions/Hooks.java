package com.academy.techcenture.step_definitions;

import com.academy.techcenture.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(order = 1)
    public void setup(Scenario scenario) {
        System.out.println("Scenario name ->" + scenario.getName());
    }

    @After
    public void teardown(Scenario scenario) {
        System.out.println("Scenario failed ->" + scenario.isFailed());
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName()); // location/extensionType
        }
        Driver.closeDriver();

    }
}
