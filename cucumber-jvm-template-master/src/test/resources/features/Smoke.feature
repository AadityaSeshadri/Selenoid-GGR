Feature: Login to Facebook and Check for Homepage

@xyz
  Scenario Outline: Facebook Login
    When User Logins Facebook with Username "<username>"  and Password "<password>"
    Then User should be able to view Homepage
    Examples:
    |username                  |password   |
    |liveyourlife5490@gmail.com|password@90|
@Login
  Scenario: Facebook Login
  Given User Navigates to Landing Page
    |https://webuildsg.github.io/data/| we build!|
    Then Validates Landing Page Elements 
    