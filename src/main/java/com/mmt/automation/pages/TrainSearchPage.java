package com.mmt.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

@SuppressWarnings("unused")
public class TrainSearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//label[@for='fromCity']")
    private WebElement fromCityInput;

    @FindBy(xpath = "//input[@placeholder='From']")
    private WebElement fromCityTextBox;

    @FindBy(xpath = "//input[@placeholder='To']")
    private WebElement toCityTextBox;

    @FindBy(xpath = "//div[contains(@class,'autoComplete')]/ul/li")
    private List<WebElement> autoCompleteOptions;

    @FindBy(xpath = "//label[@for='travelDate']")
    private WebElement dateField;

    @FindBy(xpath = "//div[contains(@class,'DayPicker-Day') and not(contains(@class,'disabled'))]")
    private List<WebElement> availableDates;

    @FindBy(xpath = "//span[contains(text(),'First AC') or contains(text(),'1A')]")
    private WebElement firstACClassOption;

    @FindBy(xpath = "//a[text()='Search']")
    private WebElement searchButton;

    public TrainSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void enterFromAndToStations(String from, String to) {
        fromCityInput.click();

        wait.until(ExpectedConditions.visibilityOf(fromCityTextBox)).sendKeys(from);
        wait.until(ExpectedConditions.visibilityOfAllElements(autoCompleteOptions));
        autoCompleteOptions.get(0).click();

        toCityTextBox.sendKeys(to);
        wait.until(ExpectedConditions.visibilityOfAllElements(autoCompleteOptions));
        autoCompleteOptions.get(0).click();
    }

    public void selectUpcomingFriday() {
        dateField.click();

        LocalDate today = LocalDate.now();
        DayOfWeek todayDay = today.getDayOfWeek();

        int daysUntilFriday = DayOfWeek.FRIDAY.getValue() - todayDay.getValue();
        if (daysUntilFriday <= 0) {
            daysUntilFriday += 7;
        }

        LocalDate nextFriday = today.plusDays(daysUntilFriday);
        String expectedDay = String.valueOf(nextFriday.getDayOfMonth());

        for (WebElement dateElement : availableDates) {
            String dayText = dateElement.getText().trim();
            if (dayText.equals(expectedDay)) {
                dateElement.click();
                break;
            }
        }
    }

    public void selectClassAndSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(firstACClassOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
}