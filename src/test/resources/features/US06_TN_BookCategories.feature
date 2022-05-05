Feature: As a data consumer, I want UI and DB book information are match.
  @us_TN_06
  @db @ui @wip
  Scenario: verify book categories with DB
    Given I am going to the  homepage
    When I am going to navigate to "Books" page
    And I am g take all book categories in webpage
    And I am going to execute query to get book categories
    Then I am going to verify book categories must match book_categories table from db