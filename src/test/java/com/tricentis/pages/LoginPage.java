package com.tricentis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Locators for the login page
    private By loginLink = By.className("ico-login");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By loginButton = By.className("login-button");
    private By logoutButton = By.className("ico-logout");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String emailAddress, String pass) {
        driver.findElement(loginLink).click();        
        driver.findElement(email).sendKeys(emailAddress);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }

    public void logout() {
        driver.findElement(logoutButton).click();
    }

}
