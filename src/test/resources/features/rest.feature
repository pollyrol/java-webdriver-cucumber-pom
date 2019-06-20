@rest
Feature: CRUD operations

  @rest1
  Scenario: Position CRUD operation
    Given I login via REST as "recruiter"
    When I create via REST new "position"
    Then I verify via REST "position" is in the list
    When I update via REST "position" with new fields
    Then I verify via REST "position" details
    And I delete via REST new "position"