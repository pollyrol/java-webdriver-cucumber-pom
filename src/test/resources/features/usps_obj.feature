@usps_obj @regression
Feature: USPS Scenarios in page object

  @usps_obj1
  Scenario: Stamps
    Given I open "usps" page
    When I go to "stamps"
    Then I verify "$0 to $5" section exists
    When I sort by "Price (Low-High)"
    Then I verify that "" is cheapest

  @usps_obj2
  Scenario: Boxes
    Given I open "usps" page
    When I go to "boxes"
    Then I verify "$0 to $5" section exists
    When I sort by "Price (Low-High)"
    Then I verify that "" is cheapest

  @usps_obj3
  Scenario: Labels
    Given I open "usps" page
    When I go to "labels"
    Then I verify that "Sign In" is required
    Then I verify that "Sign Up" is possible

