package com.finalProject.browser;

import org.openqa.selenium.WebDriver;

public class Browser {


    private static WebDriver driver;

    private Browser() {
        driver= DriverFactory.createDriver();
    }

    public static WebDriver getBrowser() {
        if (driver == null) {
            new Browser();
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }

}
