@login @regression

Feature: WebDriver University - Login

  Background:
    Given I access the webdriver university home page
    And I click on the Login Portal option

  Scenario Outline: Validate - Successful & Unsuccessful Login
    When I enter a username <username>
    And I enter a password <password>
    And I click on the Login button
    Then I should be presented with the message <loginValidationText>

    Examples:
      | username  | password     | loginValidationText  |
      | webdriver | webdriver123 | validation succeeded |
      | webdriver | webdriver1   | validation failed    |