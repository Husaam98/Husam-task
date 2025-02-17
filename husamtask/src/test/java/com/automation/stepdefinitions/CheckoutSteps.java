package com.automation.stepdefinitions;

import com.automation.base.BaseTest;
import com.automation.pages.CheckoutPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutSteps {
    private WebDriver driver;
    private CheckoutPage checkoutPage;

    public CheckoutSteps() {
        this.driver = BaseTest.getDriver();
        this.checkoutPage = new CheckoutPage(driver);
    }

    @When("the user adds the most expensive two products to the cart")
    public void addExpensiveProductsToCart() {
        checkoutPage.addMostExpensiveProducts();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @When("the user proceeds to checkout")
    public void proceedToCheckout() {
        checkoutPage.clickCart();
        checkoutPage.clickCheckout();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("the user fills in the checkout form and continues")
    public void fillCheckoutFormAndContinue() {
        checkoutPage.fillCheckoutForm("John", "Doe", "12345");
        checkoutPage.clickContinue();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the user should be on the Overview page")
    public void verifyOverviewPage() {
        assertTrue("Not on Overview page!", checkoutPage.isOverviewPageDisplayed());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the total amount before taxes should be verified")
    public void verifyTotalAmount() {
        assertTrue("Total amount mismatch!", checkoutPage.verifyTotalAmount());
    }

    @Then("the URL should match the expected checkout URL")
    public void verifyCheckoutURL() {
        assertEquals("https://www.saucedemo.com/checkout-step-two.html", driver.getCurrentUrl());
    }

    @When("the user clicks on the Finish button")
    public void clickFinishButton() {
        checkoutPage.clickFinish();
    }

    @Then("the Thank You and Order Dispatched messages should be displayed")
    public void verifyOrderConfirmation() {
        assertTrue("Thank You message not found!", checkoutPage.isThankYouMessageDisplayed());
        assertTrue("Order Dispatched message not found!", checkoutPage.isOrderDispatchedMessageDisplayed());
    }
}
