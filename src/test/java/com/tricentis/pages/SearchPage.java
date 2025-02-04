package com.tricentis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    private WebDriver driver;

    // Locator for the search box
    private By searchBox = By.id("small-searchterms");
    private By laptopLink = By.linkText("14.1-inch Laptop");
    private By addToCartButton = By.id("add-to-cart-button-31");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String item) {
        WebElement searchElement = driver.findElement(searchBox);
        searchElement.sendKeys(item);
        searchElement.submit();
    }

    public void addItemToCart() {
        driver.findElement(laptopLink).click();
        driver.findElement(addToCartButton).click();
    }
}