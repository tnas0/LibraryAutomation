@us_TN_01
Feature: As a data consumer, I want the user information are stored in mySql DB correctly in users table.
  Background:
    Given To connect the database
  @db
  Scenario: To verify users has unique IDs
  When run the query to get all IDs from users
  Then to verify all users has unique ID

  @db
  Scenario: To verify users table columns
  When run the query get all columns
  Then to verify the columns are listed in down bellow

      | id            |
      | full_name     |
      | email         |
      | password      |
      | user_group_id |
      | image         |
      | extra_data    |
      | status        |
      | is_admin      |
      | start_date    |
      | end_date      |
      | address       |
