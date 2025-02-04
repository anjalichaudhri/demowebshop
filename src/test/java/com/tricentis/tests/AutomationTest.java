package com.tricentis.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.tricentis.base.browserSingleton;
import com.tricentis.pages.LoginPage;
import com.tricentis.pages.RegistrationPage;
import com.tricentis.pages.SearchPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomationTest {

    private WebDriver driver;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    SearchPage searchPage;
    private static String generatedEmail;
    private static String generatedPassword = "Test@123"; // Static password for simplicity
    private static Faker faker = new Faker();

    // Initialize WebDriver before all tests
    @BeforeClass
    public void setup() {
        driver = browserSingleton.getDriver();
        driver.get("https://demowebshop.tricentis.com/");

        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test(priority = 1)
    public void testUserRegistration() {
        // Generate dynamic user data
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        generatedEmail = faker.internet().emailAddress();

        registrationPage.register(firstName, lastName, generatedEmail, generatedPassword);
        loginPage.logout();
    }

    // Test for User Login
    @Test(priority = 2)
    public void testUserLogin() {
        loginPage.login(generatedEmail, generatedPassword);
    }

    // Test for Searching an Item and Adding it to Cart
    @Test(priority = 3)
    public void testAddItemToCart() {
        searchPage.searchItem("Laptop");
        searchPage.addItemToCart();

        // Explicit wait to ensure the notification appears
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(
                        "//div[@id='bar-notification'][contains(.,'The product has been added to your shopping cart')]")));

        // Assert that the notification message is displayed
        Assert.assertTrue(notification.isDisplayed(), "The product was not successfully added to the shopping cart!");

        // Additional check to verify text content
        String notificationText = notification.getText();
        Assert.assertTrue(notificationText.contains("The product has been added"),
                "Unexpected notification message: " + notificationText);
    }

    // Clean up WebDriver after tests
    @AfterClass
    public void teardown() {
        browserSingleton.closeDriver();
    }
}
