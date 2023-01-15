package com.automation.hooks;

import com.automation.drivers.DriverFactory;
import com.automation.drivers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.Reporter;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        Reporter.log("############ SCENARIO STARTED for - " + scenario.getName() + " #################", true);
        new DriverFactory().initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        Reporter.log("############ SCENARIO COMPLETED for - " + scenario.getName() + " #################", true);
        DriverManager.unload();
    }
}
