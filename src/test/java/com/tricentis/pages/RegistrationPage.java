package com.tricentis.pages;

// package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;

    // Locators for the registration page
    private By registerLink = By.className("ico-register");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By email = By.id("Email");
    private By gender = By.id("gender-male");
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void register(String fName, String lName, String emailAddress, String pass) {
        driver.findElement(registerLink).click();
        driver.findElement(gender).click();
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(this.email).sendKeys(emailAddress);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
        driver.findElement(registerButton).click();
    }
}
