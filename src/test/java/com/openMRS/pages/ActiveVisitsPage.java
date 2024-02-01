package com.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ActiveVisitsPage {
    public ActiveVisitsPage(WebDriver driver){
        PageFactory.initElements(driver,this);}

   @FindBy(css = "a[id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']")
   WebElement findPatientRecord;

    @FindBy(xpath = "//td[contains(text(),'100JAN')]")
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


   @FindBy(xpath ="//div[contains(text(),'Visit Note')]")
   List<WebElement> visitNoteBtn;

   @FindBy(css = "#diagnosis-search")
    WebElement diagnosisSearch;


   @FindBy(css = "strong[class=matched-name]")
    WebElement addPresumed;

   @FindBy(xpath = "//input[@data-ng-model='d.confirmed']")
    WebElement confirmed;

   @FindBy(xpath = "//input[@class='submitButton confirm right']")
    WebElement saveBtn;

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

   @FindBy(xpath = "//a[contains(text(),'Nikolay Nikolay')]")
    WebElement endVisitPatientName;

   @FindBy(xpath = "//a[@href='javascript:visit.showEndVisitDialog(2408)']" +
           "//following-sibling::div[@class='col-11 col-lg-10']")
    WebElement endVisitBtn;

   @FindBy(xpath = "//input[@id='visitId']//following-sibling::button[contains(text(),'Yes')]")
    WebElement yesBtn;

   public void findPatient(){
       findPatientRecord.click();
       patient.click();
   }

   public void startVisit() throws InterruptedException {
       Thread.sleep(1000);
       startVisit.click();
       confirmBtn.click();
   }

   public void choosePatientForActiveVisit() throws InterruptedException {
       Thread.sleep(500);
       mainPageBtn.click();
       Thread.sleep(500);
       activeVisitsBtn.click();
       Thread.sleep(500);
       patientNameBtn.click();
       Thread.sleep(500);

       for (int i = 1;i < visitNoteBtn.size(); i++) {
           visitNoteBtn.get(i).click();


       }
   }
public void sentNvi(String nvi)  {
       diagnosisSearch.click();

       diagnosisSearch.sendKeys(nvi);
       addPresumed.click();
   }
   public void clickConfirmedAndSaveBtn() throws InterruptedException {
       confirmed.click();
       Thread.sleep(500);
       saveBtn.click();
   }
   public void headache(String headache) throws InterruptedException {
       Thread.sleep(500);
       conditionsBtn.click();
       addNewConditionBtn.click();
       conditionField.click();
       conditionField.sendKeys(headache);
   }
   public void saveClick(){
    headacheBtn.click();
    saveConditionBtn.click();
   }
   public void patientForEndVisit(){
   smallIconClickAfterSaveBtn.click();
   endVisitPatientName.click();
   }
   public void endVisit(){
       endVisitBtn.click();
       yesBtn.click();
   }





}
