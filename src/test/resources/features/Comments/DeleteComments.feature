Feature: Delete Comments

  @ProjectTeam4 @PositiveCase
  Scenario: Delete comments with valid parameter
    Given Delete comments with valid parameter id 1
    When Send request delete comments
    Then Status code should be 200 OK
    And Validate delete comments json schema valid json


  @ProjectTeam4 @NegativeCase
  Scenario: Delete comment with invalid parameter id using Alphabet
    Given Delete comment with invalid parameter id "fghj"
    When Send request delete comment invalid
    Then Response status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Delete comment with invalid parameter id using Special character
    Given Delete comment with invalid parameter id "!@#"
    When Send request delete comment invalid
    Then Response status code should be 400 Bad Request