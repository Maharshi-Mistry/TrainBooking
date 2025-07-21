package com.mmt.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//span[text()='Trains']")
    WebElement trainsTab;

    @FindBy(id = "fromCity")
    WebElement fromInput;

    @FindBy(id = "toCity")
    WebElement toInput;

    @FindBy(xpath = "//label[@for='travelDate']")
    WebElement dateField;

    @FindBy(xpath = "//span[text()='1A']")
    WebElement classFirstAC;

    @FindBy(xpath = "//a[text()='Search']")
    WebElement searchButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToTrains() {
        trainsTab.click();
    }

    public void selectStations(String from, String to) {
        fromInput.sendKeys(from);
        // logic to select dropdown option
        toInput.sendKeys(to);
    }

    public void selectUpcomingFridayAfter9PM() {
        // Use JavaScriptExecutor or date logic
    }

    public void selectClassAndSearch() {
        classFirstAC.click();
        searchButton.click();
    }
}