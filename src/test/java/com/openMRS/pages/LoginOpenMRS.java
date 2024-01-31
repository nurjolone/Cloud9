package com.openMRS.pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

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

    @FindBy(xpath = "//div[@id='error-message']")
    WebElement errorMessage;
    @FindBy(css = "li[class='nav-item logout']")
    WebElement logout;

    public void userNameAndPasswordFiled(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
    }
    public void registrationAndLoginBtn(){
        this.registrationBtn.click();
        this.loginBtn.click();
    }


    public void InvalidUserNameAndPasswordFiled(String userName, String password){
        logout.click();
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
    }


    public void validateErrorMessage(WebDriver driver,String errorMessage){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(this.errorMessage));
        Assert.assertEquals(BrowserUtils.getText(this.errorMessage),errorMessage,
                "failed during error message check");


    }












}
