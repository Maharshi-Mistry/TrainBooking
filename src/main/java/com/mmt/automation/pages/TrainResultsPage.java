package com.mmt.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.List;

public class TrainResultsPage {
    WebDriver driver;

    @FindBy(css = ".train-heading")
    List<WebElement> trainNames;

    @FindBy(css = ".ticket-price")
    List<WebElement> prices;

    public TrainResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void printAllTrainsAndPrices() {
        for (int i = 0; i < trainNames.size(); i++) {
            String name = trainNames.get(i).getText();
            String price = prices.get(i).getText();
            System.out.println("Train: " + name + ", Price: " + price);
        }
    }

    public void selectFirstTrainAfter9PM() {
        // logic to identify and click
    }
}