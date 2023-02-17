Feature: Todos Get Id API Automation Testing

  @ProjectTeam4 @PositiveCase
  Scenario: Get data with valid id
    Given Get data with valid id parameter 1
    When Send request get data with id
    Then Response status code should be 200 Oke
    And Response body should be id 1 and userId 1
    And Validator get user json schema with valid parameter id


  @ProjectTeam4 @NegativeCase
  Scenario: Get data with invalid id parameter special character
    Given Get data with invalid parameter "####"
    When Send request get user with invalid parameter
    Then Response status code should be 404 Not Found

  @ProjectTeam4 @NegativeCase
  Scenario: Get data with invalid id parameter alphabet
    Given Get data with invalid id "aya"
    When Send request get user with invalid parameter
    Then Response status code should be 404 Not Found

  @ProjectTeam4 @NegativeCase
  Scenario: Get data with id parameter unregistered
    Given Get data with id parameter 2021
    When Send request get data with id
    Then Response status code should be 404 Not Found

  @ProjectTeam4 @NegativeCase
  Scenario: Get data without id parameter
    Given Get data without id parameter
    When Send request get data without id
    Then Response status code should be 200 Oke
    And Validator get user json schema without parameter id