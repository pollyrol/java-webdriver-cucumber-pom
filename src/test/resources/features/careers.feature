@careers
Feature: Careers project

  @careers1
  Scenario: Recruiter scenario
    Given I open "careers" page
    And I login as "recruiter"
    Then I verify "recruiter" login
    When I create "automation" requisition
    And I verify "automation" position created

  @careers2
  Scenario: Careers candidate scenario
    Given I open "careers" page
    And I apply to a new position
    Then I verify profile is created
    And I see position in my jobs

  @careers3
  Scenario: Careers adds new job
    Given I open "careers" page
    And I login as "candidate"
    Then I verify "candidate" login
    When I apply for a new job
    Then I see position marked as applied
    And I see position in my jobs (edited) 