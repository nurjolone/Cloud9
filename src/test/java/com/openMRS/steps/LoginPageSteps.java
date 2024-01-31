package com.openMRS.steps;

import com.openMRS.pages.LoginOpenMRS;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class LoginPageSteps {
    WebDriver driver = DriverHelper.getDriver();
    LoginOpenMRS loginOpenMRS = new LoginOpenMRS(driver);

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
        loginOpenMRS.InvalidUserNameAndPasswordFiled(invalidUserName,invalidPassword);
    }
    @Then("user clicks on  Registration Desk and clicks loginBtn")
    public void user_clicks_on_registration_desk_and_clicks_login_btn() {
       loginOpenMRS.registrationAndLoginBtn();

    }
    @Then("user validates output {string}")
    public void user_validates_output(String errorMessage) {
        loginOpenMRS.validateErrorMessage(driver,errorMessage);


    }

}
