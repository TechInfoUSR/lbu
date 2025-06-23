package org.USRINFOTECH.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

        // Constructor
        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }

        // Locators
        private By usernameField = By.xpath("//input[@name=\"username\"]");
        private By passwordField = By.xpath("//input[@name=\"password\"]");
        private By loginButton = By.xpath("//button[@type=\"submit\"]");

        // Actions
        public void login(String username, String password) {


            driver.findElement(usernameField).sendKeys(username);
            driver.findElement(passwordField).sendKeys(password);
            driver.findElement(loginButton).click();
        }
    }
