package com.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOpenMRS {
    public LoginOpenMRS (WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(css ="input[id='username']")
    WebElement username;
    @FindBy(css = "input[id='password']")
    WebElement password;

    @FindBy (css = "li[id='Registration Desk']")
    WebElement registrationBtn;



}
