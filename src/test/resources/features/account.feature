Feature: Register Functionality for OpenCart E-commerce Website

  As a user want to register for the openCart website
  I want to be able to register with my new valid details
  So that I can access my account-related features and manage my orders

  Background:
    Given I am on OpenCart Register page

  Scenario Outline: Successfully register with new details
    Given I have entered "<FirstName>", "<LastName>", "<Email>", "<Telephone>", "<Password>" and "<Confirm_Password>"
    When I clicked on not to subscribe
    When I clicked on Agree and Continue
    Then new account should be created successfully

    Examples:
      | FirstName | LastName | Email                       | Telephone    | Password      | Confirm_Password |
      | F1        | L1       | email170220241208@email.com | 170220241208 | 1702202412081 | 1702202412081    |

  Scenario Outline: Successfully register with Existing details
    Given I have entered "<FirstName>", "<LastName>", "<Email>", "<Telephone>", "<Password>" and "<Confirm_Password>"
    When I clicked on not to subscribe
    When I clicked on Agree and Continue
    Then Warning message should be populated "<Warning>"

    Examples:
      | FirstName | LastName | Email                       | Telephone    | Password      | Confirm_Password | Warning                                        |
      | F1        | L1       | email170220241208@email.com | 170220241208 | 1702202412081 | 1702202412081    | Warning: E-Mail Address is already registered! |