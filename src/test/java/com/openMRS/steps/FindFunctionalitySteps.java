package com.openMRS.steps;

import com.openMRS.pages.FindFunctionality;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.sql.DriverManager;

public class FindFunctionalitySteps {
    WebDriver driver= DriverHelper.getDriver();
    FindFunctionality findFunctionality=new FindFunctionality(driver);

    @Given("user on main page clicks on find patient button")
    public void user_on_main_page_clicks_on_find_patient_button() {

    }
    @Then("user enters {string} and {string} and clicks enter")
    public void user_enters_and_and_clicks_enter(String string, String string2) {

    }
    @Then("user validates that  {string} and {string} are equal to given and familyName")
    public void user_validates_that_and_are_equal_to_given_and_family_name(String string, String string2) {

    }
    @Then("user clicks on delete patient button and types reason and click confirm")
    public void user_clicks_on_delete_patient_button_and_types_reason_and_click_confirm() {

    }
}
