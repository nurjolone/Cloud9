package com.openMRS.steps;

import com.openMRS.pages.RegistrationPatientPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class RegisterPageSteps {
    WebDriver driver = DriverHelper.getDriver();
    RegistrationPatientPage patientPage = new RegistrationPatientPage(driver);
    @Given("user has to feel in {string} and {string}")
    public void user_has_to_feel_in_and(String given, String familyName) throws InterruptedException {
        patientPage.setGivenNameAndFamilyName(given, familyName);

    }



    @Given("user has to choose gender")
    public void user_has_to_choose_gender() {
        patientPage.chooseGender();

    }
    @Then("user indicates the {string} and {string}")
    public void user_indicates_the_and(String day, String year) {
        patientPage.setDateOfBirth(day, year);

    }
    @Then("user has to give an {string} , {string} , {string} , {string} , {string}")
    public void user_has_to_give_an(String address, String city, String state, String country, String postalCode, io.cucumber.datatable.DataTable dataTable) {
        patientPage.setAddress(address, city, state, country, postalCode);
    }
    @Then("user indicates the {string}")
    public void user_indicates_the(String phoneNumber, io.cucumber.datatable.DataTable dataTable) {
        patientPage.setPhoneNumber(phoneNumber);

    }
    @Then("user choose type of relate person and gives name of {string}")
    public void user_choose_type_of_relate_person_and_gives_name_of(String relativeName, io.cucumber.datatable.DataTable dataTable) {
        patientPage.selectTypeOfRelative(relativeName);
    }
    @Then("user click on confirm and click on submit button")
    public void user_click_on_confirm_and_click_on_submit_button() {
        patientPage.confirmPatient();

    }


}
