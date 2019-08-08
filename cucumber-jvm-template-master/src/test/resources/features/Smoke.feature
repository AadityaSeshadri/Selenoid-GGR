Feature: Smoke Tests
Description: Purpose of this Feature is to Perform Smoke Tests  

@Login
  Scenario Outline: Facebook Login
    When User Navigates to Landing Page
    Then User must be able to see Landing Page
    Then User must be able to Click on Links to reach Separate Pages
    Examples:
    |username                  |password   |
    |liveyourlife5490@gmail.com|password@90|
