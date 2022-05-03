@us03
Feature: As a librarian, I want to know the genre of books that are being borrowed mostly

  @db
  Scenario: verify the the common book genre that’s being borrowed
    Given Establish the database connection
    When I execute query to find most popular book genre
    Then verify "Classic" is the most popular book genre.