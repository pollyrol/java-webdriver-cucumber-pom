@heroku

  Feature: Herokuapp

    @heroku1
    Scenario: Careers candidate scenario
      Given I open "careers" page
      And I apply to a new position
      Then I verify profile is created
      And I see position in my jobs

    @heroku2
    Scenario: Careers add new job
      Given I open "careers" page
      And I login as "candidate"
      Then I verify "candidate" login
      When I apply for a new job
      And I wait for 3 sec
      And I see position in my jobs

    @heroku3
    Scenario: Recruiter create a job
      Given I open "careers" page
      And I login as "recruiter"
      Then I verify "recruiter" login
      When I create "automation" position
      And I verify position created

