Feature: Orange HRM Login
  Scenario: Logo presence on OrangeHRM home page
    Given I launch chrome browser
    When I open orange hrm page
    Then I verify that the logo presence on page
    And close browser

    Scenario: Connexion
      Given I launch chrome browser
      And I open orange chrome hrm page
      When I insert the login mdp
      And I click to login button
      Then message Ok is displayed
