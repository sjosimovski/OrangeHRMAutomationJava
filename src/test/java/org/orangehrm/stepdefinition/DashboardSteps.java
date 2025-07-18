package org.orangehrm.stepdefinition;

import io.cucumber.java.en.When;
import org.orangehrm.hooks.Hooks;
import org.orangehrm.pages.DashboardPage;
import org.openqa.selenium.WebDriver;

public class DashboardSteps {

    private WebDriver driver;
    private DashboardPage dashboardPage;

    public DashboardSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
        this.dashboardPage = new DashboardPage(driver);
    }

    @When("user clicks on PIM menu")
    public void user_clicks_on_pim_menu() {
        dashboardPage.clickPIM();
    }
}
