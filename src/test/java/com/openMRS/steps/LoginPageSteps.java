package com.openMRS.steps;

import com.openMRS.pages.HomePage;
import com.openMRS.pages.LoginOpenMRS;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class LoginPageSteps {
    WebDriver driver = DriverHelper.getDriver();
    LoginOpenMRS loginOpenMRS = new LoginOpenMRS(driver);
    HomePage homePage =new HomePage(driver);

    @Given("user in OpenMrs page provides {string} and {string}")
    public void user_in_open_mrs_page_provides_and(String userName, String password) {
        loginOpenMRS.userNameAndPasswordFiled(userName,password);
    }

    @Then("user clicks Registration Desk and clicks loginBtn")
    public void user_clicks_registration_desk_and_clicks_login_btn() {
        loginOpenMRS.registrationAndLoginBtn();

    }
        @Given("user in OpenMrs page provides invalid {string} and {string}")
    public void user_in_open_mrs_page_provides_invalid_and(String invalidUserName, String invalidPassword) {
        loginOpenMRS.negativeLogin(invalidUserName,invalidPassword);
    }
    @Then("user clicks on  Registration Desk and clicks loginBtn")
    public void user_clicks_on_registration_desk_and_clicks_login_btn() {
       loginOpenMRS.registrationAndLoginBtn();

    }
    @Then("user validates output {string}")
    public void user_validates_output(String errorMessage) {
        loginOpenMRS.validateErrorMessage(driver,errorMessage);


    }
    @Given("user in OpenMrs page provides valid {string} and {string}")
    public void user_in_open_mrs_page_provides_valid_and(String userName, String password) {
        loginOpenMRS.positiveLogin(userName,password);

    }
    @Then("user clicks on  Registration Desk and clicks loginBtn to successful login")
    public void user_clicks_on_registration_desk_and_clicks_login_btn_to_successful_login() {
        loginOpenMRS.registrationAndLoginBtn();

    }
    @Then("user validates home  page {string} to check positive login")
    public void user_validates_home_page_to_check_positive_login(String header) {
        homePage.validateHeader(driver,header);

    }

}
