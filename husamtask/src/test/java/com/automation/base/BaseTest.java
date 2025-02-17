package com.automation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest {
    protected static WebDriver driver;
    private static final String BROWSER = System.getProperty("browser", "chrome"); // Default to Chrome


    @Before
    public void setup() {
        if (driver == null) {
            if (BROWSER.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");

                driver = new ChromeDriver(options);
                System.out.println("🚀 Running tests on Chrome");
            } else if (BROWSER.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();

                driver = new FirefoxDriver(options);
                System.out.println("🔥 Running tests on Firefox");
            } else {
                throw new IllegalArgumentException("Invalid browser name: " + BROWSER);
            }

            driver.manage().window().maximize();
        }
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
