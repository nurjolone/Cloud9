package com.openMRS.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class ManagePerson {

    public ManagePerson(WebDriver driver){
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//a[contains(.,'System Administration')]")
    WebElement systemAdministration;

    @FindBy(xpath = "//a[contains(.,'Advanced Administration')]")
    WebElement advancedAdministration;

    @FindBy(xpath = "//a[contains(.,'Manage Persons')]")
    WebElement managePerson;

    @FindBy(xpath = "//input[@id='inputNode']")
    WebElement personNameLine;

    @FindBy(xpath = "//input[@id='includeVoided']")
    WebElement includeDeleteBox;

    @FindBy(xpath = "//tr[@class='even']")
    List<WebElement> personNames;

    @FindBy(xpath = "//tr//td//input[@id='addresses[0].address1']")
    WebElement lineAddress;

    @FindBy(css = "#saveButton")
    WebElement savePatientBtn;

    @FindBy(xpath = "//a[contains(.,'Home')]")
    WebElement homeBtn;

    @FindBy(xpath = "//a[contains(.,'Find Patient Record')]")
    WebElement findPatientRecord;

    @FindBy(xpath = "//input[@id='patient-search']")
    WebElement searchByNameLine;

    @FindBy(xpath = "//tr//td[3]")
     WebElement findPerson;

    @FindBy(css = "#coreapps-showContactInfo")
    WebElement showContactInfo;

    @FindBy(xpath = "//span[contains(.,'Address')]")
   // @FindBy(xpath = "//div[@class='contact-info-inline labeled']//span[contains(.,'17Florida, PalatineILUSA60074')]")
    WebElement address;

@FindBy (xpath = "//tr//td[3]")
WebElement nameTinaToClick;

    public void navigatePages() {

        systemAdministration.click();
        advancedAdministration.click();

    }

    public void clickOnManagePerson() {

        managePerson.click();


    }
    public void enterPersonInfo(String name) throws InterruptedException {

        Thread.sleep(2000);
        //includeDeleteBox.click();
        personNameLine.sendKeys(name);
    }

    public void clickOnPersonInfoLine(String personName){
        for(WebElement name : personNames){
            if(BrowserUtils.getText(name).equals(personName)){
                name.click();
                //break;
            }
        }
    }

    public void changePersonInfo(String newAddress) throws InterruptedException {

        Thread.sleep(2000);
        lineAddress.clear();
        lineAddress.sendKeys(newAddress);
        savePatientBtn.click();

    }

    public void backToHomePage(){

        homeBtn.click();
    }

    public void findPatientRecord(){

        findPatientRecord.click();
    }

    public void findPatientNameAndClickEnter(String name){

        searchByNameLine.sendKeys(name, Keys.ENTER);


    }

    public void clickOnFoundedName(){
     findPerson.click();

    }

    public void validateNewAddress() throws InterruptedException {
        Thread.sleep(1000);

                showContactInfo.click();
                Assert.assertTrue(BrowserUtils.getText(address).contains("17Florida"));
                Assert.assertEquals(BrowserUtils.getText(address),"17Florida, PalatineILUSA60074\n" +
                        "Address");

    }
    public void clickTinaName(){
        nameTinaToClick.click();
    }
































}
