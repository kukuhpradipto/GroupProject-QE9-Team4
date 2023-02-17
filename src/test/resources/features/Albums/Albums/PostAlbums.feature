Feature: Albums Post Create API Automation Testing

  @ProjectTeam4 @PositiveCase
  Scenario: Post create new album with valid json file
    Given Post create new album with valid json file
    When Send request post create new album
    Then Response status code should be 201 Created
    And Response body should be userId is 1 and title "alterra"
    And Validator post create album json schema

  @ProjectTeam4 @NegativeCase
  Scenario: Post create new album with invalid data type json
    Given Post create new album with invalid data type json file
    When Send request post create new album
    Then Response status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Post create album with one parameter only
    Given Post create album with one parameter only
    When Send request post create new album
    Then Response status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Post create album with empty file json body request
    Given Post create album with empty file json body request
    When Send request post create new album
    Then Response status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Post create album with extra parameter
    Given Post create album with extra parameter
    When Send request post create new album
    Then Response status code should be 400 Bad Request



