@form
  Feature: Page Object form

    @form1
    Scenario: Submit Form page object
      Given I open "sample" page
      And I fill out sample fields
      Then I verify sample result
