@us_TN_02
Feature: As a librarian, I want to know who borrowed books
  @db @ui
  Scenario: To verify the amount of borrowed books
    Given I am in  library app's homepage
    When I will take borrowed books number
    Then borrowed books number information should be same with DB