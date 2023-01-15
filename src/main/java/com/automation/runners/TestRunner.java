package com.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/main/resources/features"},
        plugin = {"pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber.json",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                "rerun:target/failedrerun.txt"},
        glue = {"com.automation.steps", "com.automation.hooks"},
        tags = "",
        publish = false)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}

