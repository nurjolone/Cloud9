package com.openMRS.steps;

import com.openMRS.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.List;

public class HomePageSteps {
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    @Given("user in home page get all registration desks")
    public void user_in_home_page_get_all_registration_desks() {
    }
    @Then("user  clicks on every desks and validate title and click on home button:")
    public void user_clicks_on_every_desks_and_validate_title_and_click_on_home_button(io.cucumber.datatable.DataTable dataTable) {
        List<String> titles = dataTable.asList();
        homePage.validateTitles(titles);
    }

}
