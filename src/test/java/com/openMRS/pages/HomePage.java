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
        System.out.println(desks.size()); // 9
        System.out.println(desks.get(2).getText());
        for (int i = 0; i < desks.size(); i++) {
            String a = desks.get(i).getText();
            desks.get(i).click();
            switch (a){
                case "Find Patient Record":
                    Assert.assertEquals(allTitles.get(0), patientRecordTitle.getText());
                    iconHome.click();
                    break;
                case "Active Visits":
                    Assert.assertEquals(allTitles.get(1), activeVisitsTitle.getText());
                    iconHome.click();
                    break;
                case "Capture Vitals":
                    Assert.assertEquals(allTitles.get(2), vitalsTitle.getText());
                    iconHome.click();
                    break;
                case "Register a patient":
                    Assert.assertEquals(allTitles.get(3), registerPatient.getText());
                    iconHome.click();
                    break;
                case "Appointment Scheduling":
                    Assert.assertEquals(allTitles.get(4), appointmentSchedulingTitle.getText());
                    iconHome.click();
                    break;
                case "Reports":
                    Assert.assertEquals(allTitles.get(5), reportsTitle.getText());
                    iconHome.click();
                    break;
                case "Data Management":
                    Assert.assertEquals(allTitles.get(6), dataManagementTitle.getText());
                    iconHome.click();
                    break;
                case "Configure Metadata":
                    Assert.assertEquals(allTitles.get(7), metadataTitle.getText());
                    iconHome.click();
                    break;
                case "System Administration":
                    Assert.assertEquals(allTitles.get(8), administrationTitle.getText());
                    iconHome.click();
                    break;
            }
        }
    }

}
