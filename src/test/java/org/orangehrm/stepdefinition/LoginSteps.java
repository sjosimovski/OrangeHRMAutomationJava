package org.orangehrm.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.orangehrm.hooks.Hooks;
import org.orangehrm.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
        this.loginPage = new LoginPage(driver);
    }

    @Given("user is on the login page")
    public void user_is_on_login_page() {
        loginPage.openLoginPage();
    }

    @When("user logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
}
