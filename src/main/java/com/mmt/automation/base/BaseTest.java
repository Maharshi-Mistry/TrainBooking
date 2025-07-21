package com.mmt.automation.base;

import org.checkerframework.common.reflection.qual.GetClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Param;

public class BaseTest {
    protected WebDriver driver;    
    
    @BeforeClass
    //@Param("browser")
    public void setup(@Optional(chrome = "") String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new org.openqa.selenium.firefox.FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
    }

    @GetClass
    public void teardown() {
        if (driver != null) driver.quit();
    }
}