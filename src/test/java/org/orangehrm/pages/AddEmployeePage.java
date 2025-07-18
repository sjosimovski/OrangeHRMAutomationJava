package org.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AddEmployeePage extends BasePage {

    // Existing locators
    private By addEmployeeTab = By.xpath("//a[text()='Add Employee']");
    private By firstNameInput = By.name("firstName");
    private By lastNameInput = By.name("lastName");
    private By saveButton = By.xpath("//button[@type='submit' and .=' Save ']");
    private By employeeIdInput = By.xpath("//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By nationalityDropdownClick = By.cssSelector("div.oxd-select-text-input[tabindex='0']");
    private By nationalityOptions = By.cssSelector("div[role='listbox'] div[role='option']");

    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToAddEmployee() {
        clickWhenReady(addEmployeeTab);
    }

    public void fillEmployeeForm(String firstName, String lastName) {
        sendKeysWhenVisible(firstNameInput, firstName);
        sendKeysWhenVisible(lastNameInput, lastName);
    }

    public void clickSave() {
        clickWhenReady(saveButton);
    }

    public String getEmployeeId() {
        return waitForVisibility(employeeIdInput).getAttribute("value");
    }

    public void selectNationality(String nationality) {
        clickWhenReady(nationalityDropdownClick);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(nationalityOptions));

        List<WebElement> options = driver.findElements(nationalityOptions);
        for (WebElement option : options) {
            if (option.getText().trim().equalsIgnoreCase(nationality)) {
                option.click();
                break;
            }
        }
    }
}
