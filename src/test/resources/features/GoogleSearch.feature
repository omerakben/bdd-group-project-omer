Feature: Google search functionality

  @record
  Scenario: test google search for unicorns
    Given user goes to google search page
    When user enters "unicorns" in the search input box
    And user presses enter key
    Then user should see results for searched item

  @record
  Scenario: test google about link
    Given user goes to google search page
    When clicks on about link on top right
    Then user can see mission statement at the center

