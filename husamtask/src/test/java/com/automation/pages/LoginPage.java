package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By logoutButton = By.id("react-burger-menu-btn");
    private By errorButton = By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]");
    private By errorMessageElement = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLogoutButtonDisplayed() {
        return driver.findElement(logoutButton).isDisplayed();
    }

    public boolean isErrorButtonDisplayed() {
        return driver.findElement(errorButton).isDisplayed();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessageElement).getText().trim();
    }


}
