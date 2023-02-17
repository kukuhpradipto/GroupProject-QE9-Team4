Feature: Put Update Photos

  @ProjectTeam4 @PositiveCase
  Scenario: Put Update new Photos with valid json body
    Given Put Update new Photos with valid json body
    When Send request put update photos
    Then Status code should be 200 OK
    And Response body albumId should be 10, title is "api auto", url is "api.com" and thumnailUrl is "api.com"
    And Validate create photos valid json schema


  @ProjectTeam4 @NegativeCase
  Scenario: Put Update new Photos with invalid json body
    Given Put Update new Photos with invalid json body
    When Send request put update photos
    Then Status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Put Update new Photos with blank parameter on json body
    Given Put Update new Photos with blank parameter on json body
    When Send request put update photos
    Then Status code should be 400 Bad Request


  @ProjectTeam4 @NegativeCase
  Scenario: Put Update new Photos with extra parameter on json body
    Given Put Update new Photos with extra parameter on json body
    When Send request put update photos
    Then Status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Put Update new Photos with two parameter only
    Given Put Update new Photos with two parameter only
    When Send request put update photos
    Then Status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Put Update new Photos with one parameter only
    Given Put Update new Photos with one parameter only
    When Send request put update photos
    Then Status code should be 400 Bad Request