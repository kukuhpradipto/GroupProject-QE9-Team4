Feature: Todos Put Create API Automation Testing

  @ProjectTeam4 @PositiveCase
  Scenario: Put update user with valid json parameter
    Given Put update user with valid json in id 1
    When Send request put update user
    Then Response status code should be 200 Oke
    And Response body should be title userId is 5, title is "qui ullam ratione quibusdam voluptatem quia omnis"
    And Validate put json schema valid json

  @ProjectTeam4 @NegativeCase
  Scenario: Put data with invalid file json
    Given Put data with invalid file json id 1
    When Send request put update user
    Then Response status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Put data with file json user Id body request is empty
    Given Put data with file json user Id body request is empty id 1
    When Send request put update user
    Then Response status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Put data with file json title body request is empty
    Given Put data with file json title body request is empty id 1
    When Send request put update user
    Then Response status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Put data with file json completed body request is empty
    Given Put data with file json completed body request is empty id 1
    When Send request put update user
    Then Response status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Put data with file json body request is empty
    Given Put data with file json body request is empty id 1
    When Send request put update user
    Then Response status code should be 400 Bad Request
