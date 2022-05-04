@us_TN_03
Feature: As a librarian, I want to know genre of books are being borrowed the most


  @db
  Scenario: verify the the common book genre that’s being borrowed
    Given To connect with Database
    When Create query for finding most popular book genre
    Then  the most popular book genre should be "Classic".