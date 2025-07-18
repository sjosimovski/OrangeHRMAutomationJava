# OrangeHRM Automation Framework

This is a Selenium WebDriver automation framework built with **Java**, **Cucumber**, and **JUnit** for testing the OrangeHRM web application.

---

## Technologies Used

- Java 17  
- Selenium WebDriver  
- Cucumber JVM  
- JUnit 
- WebDriverManager
- GitHub

---

## Project Structure

- `pages/` – Page Object classes  
- `hooks/` – Cucumber hooks (driver setup and teardown)  
- `context/` – Shared test context class  
- `runner/` – Cucumber test runner  
- `stepdefinitions/` – Step definitions for feature files  
- `features/` – Gherkin `.feature` files

## Features

- **Full end-to-end UI test automation** for OrangeHRM employee management
- Built using **Java**, **Selenium WebDriver**, **Cucumber**, and **Maven**
- **Page Object Model (POM)** design pattern for better code organization and maintainability
- Uses **Cucumber Hooks** for test setup and teardown (browser initialization and cleanup)
- Supports **data-driven testing** with parameterized Cucumber steps
- Integration with **WebDriverManager** for automatic driver management

## How to Run Locally

### Prerequisites

- Java 17

### Steps

1. **Clone the Repository**

2. **Open the Project in IntelliJ**
   
3. **Install Dependencies**

    Maven should sync dependencies automatically via the pom.xml

4. **Run the tests**

    You can run tests using test runner or from terminal

## Test Result Screenshot

![Test Result](Images/testresult.PNG)

## Author

Stefan Josimovski

---
