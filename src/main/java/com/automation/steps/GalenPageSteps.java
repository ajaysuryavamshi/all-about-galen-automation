package com.automation.steps;

import com.automation.drivers.DriverManager;
import com.automation.utils.GalenService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class GalenPageSteps {
    private WebDriver driver = DriverManager.getDriver();

    @Given("I navigate to the landing page {string}")
    public void iNavigateToTheLandingPage(String url) {
        DriverManager.getDriver().get(url);
    }

    @Then("I verify the layout for {string} with tags {string}")
    public void iVerifyTheLayoutForWithTags(String specFileName, String tags) throws IOException {
        GalenService galenService = new GalenService();
        galenService.checkLayout(specFileName, tags);
        galenService.generateLayoutReport(specFileName);
    }
}
