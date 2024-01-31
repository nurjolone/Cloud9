package com.openMRS.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='apps']//a")
    List<WebElement> desks;

    @FindBy(xpath = "//li[contains(.,'Find Patient Record')]")
    WebElement patientRecordTitle;

    @FindBy(xpath = "//li[contains(.,'Active Visits')]")
    WebElement activeVisitsTitle;

    @FindBy(xpath = "//li[contains(.,'Capture Vitals')]")
    WebElement vitalsTitle;

    @FindBy(xpath = "//li[contains(.,'Register a patient')]")
    WebElement registerPatient;

    @FindBy(xpath = "//li[contains(.,'Appointment Scheduling')]")
    WebElement appointmentSchedulingTitle;

    @FindBy(xpath = "//li[contains(.,'Reports')]")
    WebElement reportsTitle;

    @FindBy(xpath = "//li[contains(.,'Data Management')]")
    WebElement dataManagementTitle;

    @FindBy(xpath = "//li[contains(.,'Configure Metadata')]")
    WebElement metadataTitle;

    @FindBy(xpath = "//li[contains(.,'System Administration')]")
    WebElement administrationTitle;

    @FindBy(xpath = "//i[@class='icon-home small']")
    WebElement iconHome;

    @FindBy(xpath = "//div[@class='col-12 col-sm-12 col-md-12 col-lg-12']//h4")
    WebElement header;

    public void validateHeader (WebDriver driver, String header){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(this.header));
        Assert.assertEquals(BrowserUtils.getText(this.header),header);

    }

    public void validateTitles(List<String> allTitles){
        List<WebElement> actualTitles =  new ArrayList<>(Arrays.asList(patientRecordTitle, activeVisitsTitle, vitalsTitle, registerPatient,
                                                                    appointmentSchedulingTitle, reportsTitle, dataManagementTitle, metadataTitle, administrationTitle));
        for (int i = 0; i < desks.size(); i++) {
            desks.get(i).click();
            Assert.assertEquals(allTitles.get(i), actualTitles.get(i).getText());
            iconHome.click();
        }
    }

}
