Feature: Albums Put Create API Automation Testing

  @ProjectTeam4 @PositiveCase
  Scenario: Put update data album with valid json parameter
    Given Put update data album with valid json in id 9
    When Send request put update data album
    Then Response status code should be 200 OK
    And Response body should be title userId is 9, title is "alterra"
    And Validate put json schema valid json

  @ProjectTeam4 @NegativeCase
  Scenario: Put update data album with invalid data type json parameter
    Given Put update data album with invalid data type json in id 9
    When Send request put update data album
    Then Response status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Put update data album with empty file json body request
    Given Put update data album with empty file json body request id 9
    When Send request put update data album
    Then Response status code should be 400 Bad Request