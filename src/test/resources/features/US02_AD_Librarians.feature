@us02 @ui @db
Feature: As a librarian, I want to know how many books have been borrowed
  Scenario: verify the amount of borrowed books
    Given I am on the homepage of library app
    When I take borrowed books number
    Then borrowed books number information must match with DB
