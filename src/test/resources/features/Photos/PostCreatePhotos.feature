Feature: Post Create Photos

  @ProjectTeam4 @PositiveCase
  Scenario: Post Create new Photos with valid json body
    Given Post Create new Photos with valid json body
    When Send request post create photos
    Then Status code should be 201 Created
    And Response body albumId should be 10, title is "api auto", url is "api.com" and thumnailUrl is "api.com"
    And Validate create photos valid json schema


  @ProjectTeam4 @NegativeCase
  Scenario: Post Create new Photos with invalid json body
    Given Post Create new Photos with invalid json body
    When Send request post create photos
    Then Status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Post Create new Photos with blank parameter on json body
    Given Post Create new Photos with blank parameter on json body
    When Send request post create photos
    Then Status code should be 400 Bad Request


  @ProjectTeam4 @NegativeCase
  Scenario: Post Create new Photos with extra parameter on json body
    Given Post Create new Photos with extra parameter on json body
    When Send request post create photos
    Then Status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Post Create new Photos with two parameter only
    Given Post Create new Photos with two parameter only
    When Send request post create photos
    Then Status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Post Create new Photos with one parameter only
    Given Post Create new Photos with one parameter only
    When Send request post create photos
    Then Status code should be 400 Bad Request