Feature: Login to Facebook and Check for Homepage
@initial
  Scenario Outline: Login to Facebook and check for the Existence of Homepage
    When User Navigates to Facebook and Login with Username "<Username>" and Password "<Password>"
    Then User should be able to view Homepage

    Examples:
      | Username | Password |
      |  aadityaapr5@gmail.com   |  Saraadi@90  |
      |  aadityaapr5@gmail.com   |  Saraadi@0  |

