Feature: Orange HRM Login
  Scenario: Logo presence on OrangeHRM home page
    Given I launch chrome browser
    When I open orange hrm page
    Then I verify that the logo presence on page
    And close browser
  @smoketest
    Scenario: Connexion
      Given I launch chrome browser
      And I open orange chrome hrm page
      When I insert the login mdp
      And I click to login button
      Then message Ok is displayed
   @smoketest
   Scenario: All products and filter
     Given I launch chrome browser
     And I open the gentlemensclub
     When I click to all products
     Then All products page is displayed
     When I choose to one filter option
     Then Page products is filtered