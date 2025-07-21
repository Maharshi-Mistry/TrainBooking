package com.mmt.automation.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Set;

public class TestUtil {

    public static final int DEFAULT_TIMEOUT = 20;

    // Wait for element to be visible
    public static WebElement waitForElementVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for element to be clickable
    public static WebElement waitForElementClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Click using JavaScript (for flaky or hidden elements)
    public static void clickElementJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    // Scroll into view
    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Get next Friday's date
    public static String getUpcomingFridayDate() {
        LocalDate today = LocalDate.now();
        LocalDate nextFriday = today.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return nextFriday.format(formatter);
    }

    // Switch to child window
    public static void switchToChildWindow(WebDriver driver) {
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    // Get all elements' text from a list
    public static void printAllTexts(List<WebElement> elements) {
        for (WebElement e : elements) {
            System.out.println(e.getText());
        }
    }

    // Handle alerts
    public static String acceptAlertAndGetText(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            String text = alert.getText();
            alert.accept();
            return text;
        } catch (NoAlertPresentException e) {
            return null;
        }
    }
}
