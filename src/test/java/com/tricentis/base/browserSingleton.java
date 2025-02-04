package com.tricentis.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class browserSingleton {
    private volatile static WebDriver driver;
    private static WebDriverWait wait;

    private browserSingleton() {
        if (driver != null) {
            throw new IllegalArgumentException("object already exists");
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            synchronized (browserSingleton.class) {
                String browser = System.getProperty("browser", "chrome"); // default to chrome
                if (browser.equalsIgnoreCase("chrome")) {
                    driver = new ChromeDriver();
                } else if (browser.equalsIgnoreCase("firefox")) {
                    driver = new FirefoxDriver();
                }

                //initialize wait
                wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            }

        }

        return driver;
    }

    public static void waitUnitElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitUntilElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Method to close the WebDriver
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Clean up the WebDriver instance
        }
    }

}
