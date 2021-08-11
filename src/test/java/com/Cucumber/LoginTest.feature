Feature: Login Functionality Test

  Scenario: verify Login with Invalid credentials
    Given Open Browser and Navigate to Login page
    When Enter valid email and password
    And Login success
    Then Close Test