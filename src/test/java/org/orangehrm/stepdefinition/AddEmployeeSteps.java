package org.orangehrm.stepdefinition;

import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.orangehrm.context.TestContext;
import org.orangehrm.hooks.Hooks;
import org.orangehrm.pages.AddEmployeePage;
import org.openqa.selenium.WebDriver;

public class AddEmployeeSteps {

    private WebDriver driver;
    private AddEmployeePage addEmployeePage;
    private TestContext testContext;

    public AddEmployeeSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
        this.addEmployeePage = new AddEmployeePage(driver);
        this.testContext = hooks.getTestContext();
    }

    @When("user navigates to Add Employee page")
    public void user_navigates_to_add_employee_page() {
        addEmployeePage.navigateToAddEmployee();
    }

    @And("user fills employee form with first name {string} and last name {string}")
    public void user_fills_employee_form(String firstName, String lastName) {
        addEmployeePage.fillEmployeeForm(firstName, lastName);

        testContext.setFirstName(firstName);
        testContext.setLastName(lastName);
    }

    @And("user saves the new employee")
    public void user_saves_new_employee() {
        addEmployeePage.clickSave();
        String empId = addEmployeePage.getEmployeeId();
        Assert.assertNotNull("Employee ID should be generated", empId);
        testContext.setEmployeeId(empId);
    }

    @And("user selects nationality {string} and saves again")
    public void user_selects_nationality_and_saves_again(String nationality) {
        addEmployeePage.selectNationality(nationality);
        addEmployeePage.clickSave();
    }

    @Then("employee id is generated")
    public void employee_id_is_generated() {
        Assert.assertNotNull("Employee ID should be stored in context", testContext.getEmployeeId());
    }
}
