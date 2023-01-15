package com.automation.drivers;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class DriverManager {

    private DriverManager() {

    }

    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return drivers.get();
    }

    protected static void setDriver(WebDriver driver) {
        if (Objects.nonNull(driver))
            drivers.set(driver);
    }

    public static void unload() {
        if (Objects.nonNull(getDriver())) {
            getDriver().quit();
            drivers.remove();
        }
    }
}
