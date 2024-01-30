package com.openMRS.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class FindFunctionality {
public FindFunctionality(WebDriver driver){
    PageFactory.initElements(driver,this);
}
@FindBy(xpath = "//i[@class='icon-search']")
    WebElement findPatientBtn;

@FindBy(xpath = "//input[@id='patient-search']")
    WebElement searchBar;

@FindBy(xpath = "//span[@class='PersonName-givenName']")
WebElement givenName;
@FindBy(xpath = "//span[@class='PersonName-familyName']")
WebElement familyName;

@FindBy(xpath = "//div[contains(text(),'Delete Patient')]")
WebElement deleteBtn;
@FindBy(css = "#delete-reason")
WebElement deleteReason;
@FindBy(xpath = "//div[@id='delete-patient-creation-dialog']//button[contains(text(),'Confirm')]")
WebElement confirmBtn;


public void clickOnFindPatientBtn(){
    BrowserUtils.clickOnElement(findPatientBtn);
}

public void enterPatientID(String given,String familyName){
    searchBar.sendKeys(given);
    searchBar.sendKeys(familyName, Keys.ENTER);

}

public void validateNameAndFamilyName(String given,String familyName){
    Assert.assertEquals(givenName.getText(),given);
    Assert.assertEquals(this.familyName.getText(),familyName);
}

public void deletePatient(){
    BrowserUtils.clickOnElement(deleteBtn);
    deleteReason.sendKeys("Healed");
    BrowserUtils.clickOnElement(confirmBtn);

}
}
