Feature: Todos Delete Id API Automation Testing

  @ProjectTeam4 @PositiveCase
  Scenario: Delete user with valid parameter
    Given Delete user with valid parameter id 199
    When Send request delete user
    Then Status code should be 200 OKE
    And Validate delete json schema valid json

  @ProjectTeam4 @NegativeCase
  Scenario: Delete data id with invalid parameter alphabet
    Given Delete user with valid parameter id "aya"
    When Send request delete user invalid
    Then Response status code should be 400 Bad Request

  @ProjectTeam4 @NegativeCase
  Scenario: Delete data id with invalid parameter  special character
    Given Delete user with valid parameter id "#$$"
    When Send request delete user invalid
    Then Response status code should be 400 Bad Request

  @ProjectTeam4 @PositiveCase
  Scenario: Delete data with id parameter unregistered
    Given Delete data with id parameter unregistered 201
    When Send request delete user
    Then Response status code should be 404 Not Found

  @ProjectTeam4 @PositiveCase
  Scenario: Delete  data without id parameter
    Given Delete  data without id parameter
    When Send request delete user without Id
    Then Response status code should be 404 Not Found
    And Validate delete json schema valid json


