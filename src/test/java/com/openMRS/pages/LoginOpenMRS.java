package com.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BrowserUtils;
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
    @FindBy(css = "div[class='logo']")
    WebElement openMrsLogo;
    @FindBy(xpath = "//a[@id='cantLogin']")
    WebElement cantLoginBtn;
    @FindBy(xpath = "//p[@class='dialog-instructions']")
    WebElement popupMessage;
    @FindBy(xpath = "//button[@class='confirm']")
    WebElement okBtn;


    public void userNameAndPasswordFiled(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
    }
    public void registrationAndLoginBtn(){
        this.registrationBtn.click();
        this.loginBtn.click();
    }


    public void negativeLogin(String userName, String password){
        logout.click();
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
    }
    public void positiveLogin(String userName, String password){
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
    public void clickOpenMrsCantLoginBtn(WebDriver driver) throws InterruptedException {
        BrowserUtils.clickWithActions(driver,openMrsLogo);
        Thread.sleep(2000);
        BrowserUtils.clickWithJs(driver,cantLoginBtn);
        Thread.sleep(2000);
    }
    public void validatePopupMsg(WebDriver driver,String popupMessage) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(BrowserUtils.getText(this.popupMessage),popupMessage,
                "failed during popup message validation");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        BrowserUtils.clickWithJs(driver,okBtn);
    }


}
