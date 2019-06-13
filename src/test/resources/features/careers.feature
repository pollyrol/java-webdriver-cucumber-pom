@careers
<<<<<<< HEAD
Feature: Careers project

  @careers1
  Scenario: Recruiter scenario
    Given I open "careers" page
    And I login as "recruiter"
    Then I verify "recruiter" login
    When I create "automation" requisition
    And I verify position created
=======
  Feature: Careers project

    @careers1
    Scenario: Recruiter scenario
      Given I open "careers" page
      And I login as "recruiter"
      Then I verify "recruiter" login
      When I create "automation" requisition
      And I verify position created
>>>>>>> 17cfc0f5c4dda2d9035ba767beff4744bacf95d1
