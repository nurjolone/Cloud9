package com.openMRS.steps;

import com.openMRS.pages.CreatePatient;
import com.openMRS.pages.DataForApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class DataApiSteps {
WebDriver driver = DriverHelper.getDriver();
DataForApi data = new DataForApi(driver);

    @Given("User on OpenMrs WebSite provides username {string}  password {string}")
    public void user_on_open_mrs_web_site_provides_username_password(String userName, String password) {
        data.loginApi(userName,password);
    }
    @Given("User Clicks Registration desk And Clicks LoginBtn")
    public void user_clicks_registration_desk_and_clicks_login_btn() {
       data.setRegistrationBtnandLoginBtn();
    }
    @Then("user click find patient window and enters patient ID and click enter")
    public void user_click_find_patient_window_and_enters_patient_id_and_click_enter() throws InterruptedException {
       data.findPatientClickAndInterID();
    }
    @Then("User validates patient is on the list or not")
    public void user_validates_patient_is_on_the_list_or_not() throws InterruptedException {
        data.validateCreatedPerson();

    }
}
