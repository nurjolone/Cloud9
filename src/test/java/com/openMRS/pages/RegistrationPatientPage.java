package com.openMRS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class RegistrationPatientPage {
    public RegistrationPatientPage(WebDriver driver) {
        PageFactory.initElements(driver, this);


    }
    @FindBy(css = "a[id='referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']")
    WebElement registerButton;

    @FindBy(css = "input[name='givenName']")
    WebElement givenName;

    @FindBy(css ="input[name='familyName']")
    WebElement familyName;

    @FindBy(css = "span[id='genderLabel']")
    WebElement genderButton;
    @FindBy(css = "option[value='M']")
    WebElement clickOnMale;

    @FindBy(css = "span[id='birthdateLabel']")
    WebElement dateOfBirthButton;
    @FindBy(css = "input[id='birthdateDay-field']")
    WebElement birthDay;
    @FindBy(css = "select[id='birthdateMonth-field']")
    WebElement birthMonth;
    @FindBy(css ="input[id='birthdateYear-field']")
    WebElement birthYear;

    @FindBy(xpath = "//span[.='Address']")
    WebElement addressButton;

    @FindBy(css ="input[id='address1']")
    WebElement addressLine;
    @FindBy(css = "input[id='cityVillage']")
    WebElement city;
    @FindBy(css = "input[id='stateProvince']")
    WebElement state;
    @FindBy(css = "input[id='country']")
    WebElement country;
    @FindBy(css = "input[id='postalCode']")
    WebElement postalCode;

    @FindBy(xpath = "//span[.='Phone Number']")
    WebElement phoneButton;

    @FindBy(css = "input[name='phoneNumber']")
    WebElement indicatePhoneNumber;

    @FindBy(xpath = "//span[.='Relatives']")
    WebElement relativeButton;

    @FindBy(css ="select[id='relationship_type']")
    WebElement selectTypeOfRelative;

    @FindBy(css = "input[placeHolder='Person Name']")
    WebElement nameOfRelative;

    @FindBy(css = "button[class='confirm right']")
    WebElement confirmButton;
    @FindBy(css = "input[id='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//i[@class='icon-home small']")
    WebElement iconHome;

    public void setGivenNameAndFamilyName(String given, String familyName) throws InterruptedException {
        registerButton.click();
        Thread.sleep(1000);
        this.givenName.sendKeys(given);
        this.familyName.sendKeys(familyName);
        genderButton.click();
    }
    public void chooseGender(){
        clickOnMale.click();
        dateOfBirthButton.click();
    }
    public void setDateOfBirth(String day, String year){
        this.birthDay.sendKeys(day);
        BrowserUtils.selectBy(birthMonth, "April", "visibleText");
        this.birthYear.sendKeys(year);
        addressButton.click();

    }
    public void setAddress(String address, String city, String state, String country, String postalCode ){
        this.addressLine.sendKeys(address);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.country.sendKeys(country);
        this.postalCode.sendKeys(postalCode);
        phoneButton.click();
    }
    public void setPhoneNumber(String phoneNumber){
        this.indicatePhoneNumber.sendKeys(phoneNumber);
        relativeButton.click();
    }
    public void selectTypeOfRelative(String relativeName){
        BrowserUtils.selectBy(selectTypeOfRelative, "Patient", "visibleText");
        this.nameOfRelative.sendKeys(relativeName);
        confirmButton.click();
        submitButton.click();



    }
    public void confirmPatient(){
        try {
            confirmButton.click();
            iconHome.click();
        } catch(StaleElementReferenceException e) {
            e.getMessage();
        }

    }






}


