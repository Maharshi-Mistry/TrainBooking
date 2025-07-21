package com.mmt.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class BookingPage {
    WebDriver driver;

    @FindBy(id = "travellerName")
    WebElement nameField;

    @FindBy(id = "payNow")
    WebElement payNowBtn;

    @FindBy(css = ".error-msg")
    WebElement errorMsg;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillTravelerDetails(String name) {
        nameField.sendKeys(name);
    }

    public void clickPayAndBook() {
        payNowBtn.click();
    }

    public void printErrorAndDetails() {
        System.out.println("Error: " + errorMsg.getText());
        // Capture other details if needed
    }
}