Feature: Login to Facebook and Check for Homepage
  Background:
@Login
  Scenario Outline: Facebook Login
    When User Logins Facebook with Username "<username>"  and Password "<password>"
    Then User should be able to view Homepage
    Examples:
    |username                  |password   |
    |liveyourlife5490@gmail.com|password@90|
