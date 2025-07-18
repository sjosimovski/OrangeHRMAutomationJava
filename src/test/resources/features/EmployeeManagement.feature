Feature: Employee Management

  Scenario: Add a new employee and verify it appears in the employee list
    Given user is on the login page
    When user logs in with username "admin" and password "admin123"
    And user clicks on PIM menu
    And user navigates to Add Employee page
    And user fills employee form with first name "John" and last name "Smith"
    And user saves the new employee
    And user selects nationality "Canadian" and saves again
    Then employee id is generated
    When user navigates to Employee List page
    And user searches for employee by id
    Then employee with id, first name and last name should be found
