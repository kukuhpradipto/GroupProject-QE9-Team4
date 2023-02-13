Feature: Todos Post Create API Automation Testing

  Scenario: Post create new user with valid json file
    Given Post create new user with valid json file
    When Send request post create new user
    Then Response status code should be 201 Created
    And Response body should be userId is 1
    And Validator post create user json schema