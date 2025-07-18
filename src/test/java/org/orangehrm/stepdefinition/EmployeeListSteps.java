package org.orangehrm.stepdefinition;

import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.orangehrm.context.TestContext;
import org.orangehrm.hooks.Hooks;
import org.orangehrm.pages.EmployeeListPage;
import org.openqa.selenium.WebDriver;

public class EmployeeListSteps {

    private WebDriver driver;
    private EmployeeListPage employeeListPage;
    private TestContext testContext;

    public EmployeeListSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
        this.employeeListPage = new EmployeeListPage(driver);
        this.testContext = hooks.getTestContext();
    }

    @When("user navigates to Employee List page")
    public void user_navigates_to_employee_list_page() {
        employeeListPage.navigateToEmployeeList();
    }

    @And("user searches for employee by id")
    public void user_searches_for_employee_by_id() {
        String empId = testContext.getEmployeeId();
        Assert.assertNotNull("Employee ID should be available in context", empId);
        employeeListPage.searchByEmployeeId(empId);
    }

    @Then("employee with id, first name and last name should be found")
    public void employee_with_id_and_names_should_be_found() {
        String empId = testContext.getEmployeeId();
        String firstName = testContext.getFirstName();
        String lastName = testContext.getLastName();

        Assert.assertNotNull("Employee ID is not correct", empId);
        Assert.assertNotNull("First Name is not correct", firstName);
        Assert.assertNotNull("Last Name is not correct", lastName);

        boolean found = employeeListPage.isEmployeeFound(empId, firstName, lastName);
        Assert.assertTrue("Employee with ID " + empId + ", Name " + firstName + " " + lastName + " should be found", found);
    }
}
