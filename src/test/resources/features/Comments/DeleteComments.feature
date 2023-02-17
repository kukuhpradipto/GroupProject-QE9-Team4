Feature: Delete Comments

  @ProjectTeam4 @PositiveCase
  Scenario: Delete comments with valid parameter
    Given Delete comments with valid parameter id 199
    When Send request delete comments
    Then Status code should be 200 OK
    And Validate delete comments json schema valid json