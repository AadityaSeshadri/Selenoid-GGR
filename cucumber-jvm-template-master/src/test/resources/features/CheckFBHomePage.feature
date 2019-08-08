Feature: Homepage
Description: Purpose of this Feature is to test Home Page Validations 
  Background:
@Login
  Scenario Outline: Facebook Login
    When User Logins Facebook with Username "<username>"  and Password "<password>"
    Then User should be able to view Homepage
    Examples:
    |username                  |password   |
    |liveyourlife5490@gmail.com|password@90|
@Login
  Scenario Outline: Home page Componenets
    When User Logins Facebook with Username "<username>"  and Password "<password>"
    Then User should be able to view Homepage
    Examples:
    |username                  |password   |
    |liveyourlife5490@gmail.com|password@90|