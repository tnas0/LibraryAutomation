@us_TN_04
Feature: As a librarian, I want to know all the students who borrowed books

  @db
  Scenario: verify who is most popular user who reads the most
    Given Establish the database connection successfully
    When  to find most popular user
    Then To verify "Test Student 1" likes to read more