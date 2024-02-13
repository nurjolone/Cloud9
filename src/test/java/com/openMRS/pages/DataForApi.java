package com.openMRS.pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.security.Key;

public class DataForApi  {
public DataForApi(WebDriver driver){
    PageFactory.initElements(driver,this);
}
    String familyName="";
    String gender="";
    String birthdate = "";
    String cityVillage = "";

    @FindBy(xpath ="//input[@id='username' and @name='username']")
    WebElement userName;
    @FindBy(css = "input[id='password']")
    WebElement password;
    @FindBy(xpath = "//a[contains(.,'Logout')]")
    WebElement logout;

    @FindBy (css = "li[id='Registration Desk']")
    WebElement registrationBtn;
    @FindBy(css = "input[id='loginButton']")
    WebElement loginBtn;
    @FindBy(xpath = "//a[contains(.,'Find Patient Record')]")
    WebElement findPatientRecord;
   // @FindBy(xpath = "//input[@class='form-control']")
    @FindBy(css = "#patient-search")
    WebElement inputName;
    @FindBy (xpath = "//td[contains(.,'NIP How Are Guys?')]")
    WebElement kim;



    public void loginApi(String userName, String password){
        logout.click();
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
    }
    public void setRegistrationBtnandLoginBtn(){
        this.registrationBtn.click();
        this.loginBtn.click();
    }


  public void findPatientClickAndInterID () throws InterruptedException {
      Thread.sleep(2000);
      findPatientRecord.click();
      Thread.sleep(2000);
      CreatePatient createPatient = new CreatePatient();
      createPatient.CreatePerson();
      inputName.sendKeys(CreatePatient.alex);
  }
      public void validateCreatedPerson() throws InterruptedException {
          Thread.sleep(5000);
          Assert.assertEquals("NIP How Are Guys? Che Tam Bratishki?", kim.getText());
          System.out.println(kim.getText());
      }
  }







