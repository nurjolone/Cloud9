package com.openMRS.pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

public class LoginOpenMRS {
    public LoginOpenMRS (WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(css ="input[id='username']")
    WebElement userName;
    @FindBy(css = "input[id='password']")
    WebElement password;

    @FindBy (css = "li[id='Registration Desk']")
    WebElement registrationBtn;
    @FindBy(css = "input[id='loginButton']")
    WebElement loginBtn;

    public void userNameAndPasswordFiled(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
    }
    public void registrationAndLoginBtn(){
        this.registrationBtn.click();
        this.loginBtn.click();
    }










}
