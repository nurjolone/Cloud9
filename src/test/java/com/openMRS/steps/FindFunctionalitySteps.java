package com.openMRS.steps;

import com.openMRS.pages.FindFunctionality;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.sql.DriverManager;
import java.time.Duration;

public class FindFunctionalitySteps {
    WebDriver driver = DriverHelper.getDriver();
    FindFunctionality findFunctionality = new FindFunctionality(driver);

    @Given("user on main page clicks on find patient button")
    public void user_on_main_page_clicks_on_find_patient_button() {
        findFunctionality.clickOnFindPatientBtn();

    }

    @Then("user enters {string} and {string} and clicks enter")
    public void user_enters_and_and_clicks_enter(String given, String familyName) {
        findFunctionality.enterGivenAndFamilyName(given, familyName);

    }

    @Then("user validates that  {string} and {string} are equal to given and familyName")
    public void user_validates_that_and_are_equal_to_given_and_family_name(String given, String familyName)  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        findFunctionality.validateNameAndFamilyName(given, familyName);

    }

    @Then("user clicks on delete patient button and types reason and click confirm")
    public void user_clicks_on_delete_patient_button_and_types_reason_and_click_confirm() throws InterruptedException {
        findFunctionality.deletePatient(driver);

    }
}
