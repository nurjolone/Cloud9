package com.openMRS.steps;

import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;


public class OpenMRShook {
    WebDriver driver = DriverHelper.getDriver();

    @Before
    public void setUp(){
        driver.get(ConfigReader.readProperty("URL"));
    }
}

