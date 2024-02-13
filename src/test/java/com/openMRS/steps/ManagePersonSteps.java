package com.openMRS.steps;

import com.openMRS.pages.ManagePerson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class ManagePersonSteps {

    WebDriver driver = DriverHelper.getDriver();

    ManagePerson managePerson = new ManagePerson(driver);

    @Given("User is on home page and clicks button System Administration and clicks Advanced Administration")
    public void user_is_on_home_page_and_clicks_button_system_administration_and_clicks_advanced_administration() {
        managePerson.navigatePages();


    }
    @Then("User clicks button Manage Person")
    public void user_clicks_button_manage_person() {
        managePerson.clickOnManagePerson();

    }
    @Then("User enters {string} into line Person Name and clicks checkbox Include deleted")
    public void user_enters_into_line_person_name_and_clicks_checkbox_include_deleted(String name)  {

        managePerson.enterPersonInfo(driver,name);
        managePerson.clickOnPersonInfoLine(name);

    }
    @Then("user clicks on person info line")
    public void user_clicks_on_person_info_line() {
        managePerson.clickTinaName();
    }
    @Then("User deletes existing address in line Address and enter {string} and clicks the button Save Patient")
    public void user_deletes_existing_address_in_line_address_and_enter_and_clicks_the_button_save_patient(String newAddress)  {
        managePerson.changePersonInfo(driver,newAddress);

    }
    @Then("User comes back on home page by clicking link Home")
    public void user_comes_back_on_home_page_by_clicking_link_home() {
        managePerson.backToHomePage();

    }
    @Then("User is on home page and clicks button Find Person Record")
    public void user_is_on_home_page_and_clicks_button_find_person_record() {
        managePerson.findPatientRecord();

    }
    @Then("enters patient {string} in the insert line and click Enter")
    public void enters_patient_in_the_insert_line_and_click_enter(String name) {
        managePerson.findPatientNameAndClickEnter(name);
        managePerson.clickOnFoundedName();
    }

    @Then("User clicks dropdown Show Contact Info and validates information about address")
    public void user_clicks_dropdown_show_contact_info_and_validates_information_about_address() {
        managePerson.validateNewAddress(driver);
    }

}
