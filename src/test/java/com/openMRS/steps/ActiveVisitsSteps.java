package com.openMRS.steps;

import com.openMRS.pages.ActiveVisitsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class ActiveVisitsSteps {
    WebDriver driver = DriverHelper.getDriver();
    ActiveVisitsPage visitsPage =new ActiveVisitsPage(driver);



    @Given("user is on main page and clicks on find patient record, chooses a patient and clicks on it")
    public void user_is_on_main_page_and_clicks_on_find_patient_record_chooses_a_patient_and_clicks_on_it() {

        visitsPage.findPatient();
    }
    @Then("user clicks on start visit button and then on confirm button")
    public void user_clicks_on_start_visit_button_and_then_on_confirm_button() throws InterruptedException {
       visitsPage.startVisit(driver);
    }
    @Then("user clicks on main page, clicks active visits, chooses the patient, then clicks visits noe")
    public void user_clicks_on_main_page_clicks_active_visits_chooses_the_patient_then_clicks_visits_noe() throws InterruptedException {
        visitsPage.choosePatientForActiveVisit(driver);
    }
    @Then("under add presumed user {string} nvi and clicks on nonCodeNviOption")
    public void under_add_presumed_user_nvi_and_clicks_on_non_code_nvi_option(String nvi) {
        visitsPage.sentNvi(nvi);
    }
    @Then("user clicks confirmed and save button")
    public void user_clicks_confirmed_and_save_button(){
        visitsPage.clickConfirmedAndSaveBtn(driver);

    }
    @Then("user clicks conditions, add new conditions and provides {string} headache")
    public void user_clicks_conditions_add_new_conditions_and_provides_headache(String headache) throws InterruptedException {
        visitsPage.headache(driver,headache);
    }
    @Then("user clicks on headache given option and clicks on save button")
    public void user_clicks_on_headache_given_option_and_clicks_on_save_button() {
        visitsPage.saveClick();
    }
    @Then("user clicks on main page button, clicks active visits, clicks on patient")
    public void user_clicks_on_main_page_button_clicks_active_visits_clicks_on_patient() throws InterruptedException {
        visitsPage.patientForEndVisit(driver);
    }
    @Then("user clicks end visit and clicks yes button")
    public void user_clicks_end_visit_and_clicks_yes_button() {

        visitsPage.endVisit();
    }

}
