package com.openMRS.pages;

import io.cucumber.java.en.Then;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class ActiveVisitsPage {
    public ActiveVisitsPage(WebDriver driver){
        PageFactory.initElements(driver,this);}

   @FindBy(css = "a[id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']")
   WebElement findPatientRecord;

    @FindBy(xpath = "//td[contains(text(),'100JWH')]")
    WebElement patient;

    @FindBy(xpath = "//div[contains(text(),'Start Visit')] ")
    WebElement startVisit;

    @FindBy(xpath = "//button[@id='start-visit-with-visittype-confirm']")
    WebElement confirmBtn;

   @FindBy(xpath = "//i[@class='icon-home small']")
    WebElement mainPageBtn;

   @FindBy(xpath =
           "//a[@id='org-openmrs-module-coreapps-activeVisitsHomepageLink-" +
                   "org-openmrs-module-coreapps-activeVisitsHomepageLink-extension']")
    WebElement activeVisitsBtn;

   @FindBy(xpath = "//tr//td[2]")
    WebElement patientNameBtn;

   @FindBy(xpath = "//h3[.='CONDITIONS']//following-sibling::i")
    WebElement conditionsBtn;

   @FindBy(css = "#conditionui-addNewCondition")
    WebElement addNewConditionBtn;

   @FindBy(css = "#conceptId-input")
    WebElement conditionField;

   @FindBy(xpath = "//a[@tabindex='-1']")
    WebElement headacheBtn;

   @FindBy(css = "#addConditionBtn")
    WebElement saveConditionBtn;

   @FindBy(xpath = "//i[@class='icon-home small']")
    WebElement smallIconClickAfterSaveBtn;

    @FindBy(xpath = "//a[contains(.,'Active Visits')]")
    WebElement endVisitBtn;
    @FindBy(xpath = "//a[contains(text(),'Nikolay Nikolay')]")
    WebElement endVisitPatientName;
    @FindBy(xpath = "//div[@class='row']//following-sibling::i[@class='icon-off']")
    List<WebElement> endVisitPatient;
    @FindBy(xpath = "//button[.='Yes']")
    List<WebElement> yesBtnAfterEndVisitPopup;
    @FindBy(xpath = "//i[@class='icon-off']")
    List<WebElement> endVisitListSsPopUp;
   @FindBy(xpath = "//input[@id='visitId']//following-sibling::button[contains(text(),'Yes')]")
    WebElement yesBtn;

   public void findPatient(){
       findPatientRecord.click();
       patient.click();
   }

   public void startVisit(WebDriver driver){
       for (int i = 1; i <endVisitListSsPopUp.size() ; i++) {
           if(endVisitListSsPopUp.get(i).isDisplayed()){
               endVisitPatient.get(i).click();
               yesBtnAfterEndVisitPopup.get(i).click();
           }
       }
       BrowserUtils.clickOnElement(driver, startVisit);
       BrowserUtils.clickOnElement(driver, confirmBtn);
   }


   public void choosePatientForActiveVisit(WebDriver driver){
       try {
           BrowserUtils.clickOnElement(driver, mainPageBtn);
           BrowserUtils.clickOnElement(driver, activeVisitsBtn);
           BrowserUtils.clickOnElement(driver, patientNameBtn);
       } catch(StaleElementReferenceException e) {
           e.getMessage();
       }

   }
   public void headache(WebDriver driver,String headache){
       BrowserUtils.clickOnElement(driver, conditionsBtn);
       BrowserUtils.clickOnElement(driver, addNewConditionBtn);
       BrowserUtils.clickOnElement(driver, conditionField);
       conditionField.sendKeys(headache);
   }
   public void saveClick(){
    headacheBtn.click();
    saveConditionBtn.click();
   }
   public void patientForEndVisit(WebDriver driver){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       wait.until(ExpectedConditions.visibilityOf(this.smallIconClickAfterSaveBtn));
   smallIconClickAfterSaveBtn.click();

           endVisitBtn.click();
           endVisitPatientName.click();

   }
   public void endVisit(){
       for (int i = 1; i < endVisitPatient.size(); i++) {
           endVisitPatient.get(i).click();

       }

       yesBtn.click();
   }





}
