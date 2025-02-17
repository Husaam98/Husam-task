package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckoutPage {
    private WebDriver driver;

    // Locators
    private By productPrices = By.className("inventory_item_price");
    private By addToCartButtons = By.className("btn_inventory");
    private By cartButton = By.className("shopping_cart_link");
    private By checkoutButton = By.id("checkout");
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By overviewTitle = By.className("title");
    private By totalAmount = By.className("summary_subtotal_label");
    private By finishButton = By.id("finish");
    private By thankYouMessage = By.className("complete-header");
    private By orderDispatchedMessage = By.className("complete-text");

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Add most expensive products to cart
    public void addMostExpensiveProducts() {
        List<WebElement> priceElements = driver.findElements(productPrices);
        List<Double> prices = new ArrayList<Double>();

        // Extract and convert prices to double
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", ""); // Remove $
            prices.add(Double.parseDouble(priceText)); // Convert to Double
        }

        // Sort prices in descending order
        Collections.sort(prices, Collections.reverseOrder());

        List<WebElement> addButtons = driver.findElements(addToCartButtons);

        // Add the top 2 most expensive products to the cart
        for (int i = 0; i < 2; i++) {
            addButtons.get(i).click();
        }
    }

    public void clickCart() {
        driver.findElement(cartButton).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public boolean isOverviewPageDisplayed() {
        return driver.findElement(overviewTitle).getText().contains("Overview");
    }

    public boolean verifyTotalAmount() {
        return driver.findElement(totalAmount).isDisplayed();
    }

    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    public boolean isThankYouMessageDisplayed() {
        return driver.findElement(thankYouMessage).isDisplayed();
    }

    public boolean isOrderDispatchedMessageDisplayed() {
        return driver.findElement(orderDispatchedMessage).isDisplayed();
    }
}
