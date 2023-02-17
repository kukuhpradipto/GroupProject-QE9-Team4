Feature: Todos Post Create API Automation Testing

  @ProjectTeam4 @PositiveCase
  Scenario: Post create new user with valid json file
    Given Post create new user with valid json file
    When Send request post create new user
    Then Response status code should be 201 Created
    And Response body should be userId is 1
    And Validator post create user json schema

  @ProjectTeam4 @NegativeCase
  Scenario: Post create new user with invalid json
    Given Post create new user with invalid json
    When Send request post create new user
    Then Response status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Post data with file json user id body request is empty
    Given Post data with file json user id  body request is empty
    When Send request post create new user
    Then Response status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Post data with file json title body request is empty
    Given Post data with file json title body request is empty
    When Send request post create new user
    Then Response status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Post data with file json completed body request is empty
    Given Post data with file json completed body request is empty
    When Send request post create new user
    Then Response status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Post data with file json body request is empty
    Given Post data with file json body request is empty
    When Send request post create new user
    Then Response status code should be 400 Bad Request
