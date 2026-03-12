# DemoQA Registration Form UI Automation

Automated UI tests for the DemoQA Registration Form built with Java, TestNG, Selenide, and Allure.

## Overview

This project contains automated tests for the registration form available at:

https://demoqa.com/automation-practice-form

The implementation follows the Page Object Model pattern and includes:
- positive UI scenarios
- validation checks for required fields
- Allure reporting with detailed steps
- retry mechanism for flaky tests

## Tech stack

- Language: Java 17
- Build tool: Maven
- Test framework: TestNG
- UI automation: Selenide
- Reporting: Allure Report

## Implemented scenarios

The project currently covers 3 main scenarios:

1. Successful registration with all main fields filled
    - fills the form
    - submits it
    - verifies the result modal content

2. Validation of required fields
    - submits the form without filling required data
    - verifies that required fields are highlighted as invalid

3. Successful registration with only required fields
    - fills only mandatory fields
    - submits the form
    - verifies successful submission
## Quick Start

### Run Tests
Run the TestNG test suite using Maven:
```bash
mvn clean test "-Dsurefire.suiteXmlFiles=src/test/resources/testng.xml"
```
### Generate and Open Allure Report
After the tests finish, generate and open the Allure report:
```bash
mvn allure:serve
