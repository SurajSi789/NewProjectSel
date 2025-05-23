Feature: Login Page Functional Testing

	Background:
		Given User is on the Login Page

  @PositiveTesting
  Scenario: Testing Login using valid credentials
    When User enters username
    And User enters password
    And User clicks on Login button
    Then User is redirected to Product page

  @NegativeTesting
  Scenario Outline: Testing Login using invalid username
    When User enters invalid "<username>"
    And User enters password
    And User clicks on Login button
    Then User will get a error message

    Examples: 
      | username  |
      |   10      | # data to be taken from row 0 and cell 0
      |   20      | # data to be taken from row 1 and cell 0
