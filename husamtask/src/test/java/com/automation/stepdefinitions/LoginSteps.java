package com.automation.stepdefinitions;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import com.automation.utils.ConfigReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {
	private WebDriver driver;
	private LoginPage loginPage;

	public LoginSteps() {
		System.out.println("Initializing LoginSteps...");
		this.driver = BaseTest.getDriver();
		this.loginPage = new LoginPage(driver);
		System.out.println("WebDriver in LoginSteps: " + driver);
	}

	@Given("the user navigates to the login page")
	public void navigateToLoginPage() {
		String baseUrl = ConfigReader.getProperty("base.url"); // ✅ Fetch URL dynamically
		System.out.println("Navigating to: " + baseUrl);
		driver.get(baseUrl);
	}

	@When("the user enters invalid username {string} and password {string}")
	public void enterInvalidCredentials(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
	}

	@Then("the user should see a login error message {string}")
	public void verifyLoginErrorMessage(String expectedErrorMessage) {
		String actualErrorMessage = loginPage.getErrorMessage();
		assertEquals("Error message mismatch!", expectedErrorMessage, actualErrorMessage);
	}

	@When("the user enters valid username and password")
	public void enterValidCredentials() {
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();
	}

	@When("the user enters Invalid username and password")
	public void enterinValidCredentials() {
		loginPage.enterUsername("standard_userTest");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();
	}

	@Then("the user should be logged in successfully")
	public void verifyLogin() {
		assertTrue("Login successfully!", loginPage.isLogoutButtonDisplayed());
	}

}
