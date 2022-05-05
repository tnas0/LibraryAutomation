@us_TN_05
Feature: As a data consumer, I want UI and DB book information are match

  @db @ui
  Scenario: To verify book information with DB
    Given I am going to the homepage of library app
    When I will navigate to "Books" page
    And I will open a book called "Chordeiles minor"
    And I will run query to get the book information from books table
    Then To verify book DB and UI information should be same