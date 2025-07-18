package org.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class EmployeeListPage extends BasePage {

    private By employeeListTab = By.xpath("//a[text()='Employee List']");
    private By searchIdInput = By.xpath("//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]/descendant::input");
    private By searchButton = By.xpath("//button[@type='submit' and .=' Search ']");
    private By tableResults = By.cssSelector("div.oxd-table-body");
    private By tableRows = By.cssSelector("div.oxd-table-card");
    private By employeeIdCellRelative = By.xpath(".//div[contains(@class,'oxd-table-cell')][2]/div");
    private By firstNameCellRelative = By.xpath(".//div[contains(@class,'oxd-table-cell')][3]/div");
    private By lastNameCellRelative = By.xpath(".//div[contains(@class,'oxd-table-cell')][4]/div");

    public EmployeeListPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToEmployeeList() {
        clickWhenReady(employeeListTab);
    }

    public void searchByEmployeeId(String id) {
        sendKeysWhenVisible(searchIdInput, id);
        clickWhenReady(searchButton);
    }

    public boolean isEmployeeFound(String expectedId, String expectedFirstName, String expectedLastName) {
        waitForVisibility(tableResults);
        waitForVisibility(tableRows);
        List<WebElement> rows = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tableRows));

        for (WebElement row : rows) {
            String actualId = row.findElement(employeeIdCellRelative).getText().trim();
            String actualFirstName = row.findElement(firstNameCellRelative).getText().trim();
            String actualLastName = row.findElement(lastNameCellRelative).getText().trim();

            if (actualId.equals(expectedId)
                    && actualFirstName.equalsIgnoreCase(expectedFirstName)
                    && actualLastName.equalsIgnoreCase(expectedLastName)) {
                return true;
            }
        }
            return false;
    }
}
