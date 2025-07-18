package org.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private final String url = "https://opensource-demo.orangehrmlive.com/";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        driver.get(url);
        waitForVisibility(usernameInput);
    }

    public void enterUsername(String username) {
        sendKeysWhenVisible(usernameInput, username);
    }

    public void enterPassword(String password) {
        sendKeysWhenVisible(passwordInput, password);
    }

    public void clickLogin() {
        clickWhenReady(loginButton);
    }
}
