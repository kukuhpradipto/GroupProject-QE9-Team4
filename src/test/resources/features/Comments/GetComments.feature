Feature: Get Comments

  @ProjectTeam4 @PositiveCase
  Scenario: Get comments with valid parameter id
    Given Get comments with valid parameter id 1
    When Send get comments request
    Then Status code should be 200 OK
    And Response body should be postId 1 and id 1
    And Validate get comments json schema with valid parameter id



  @ProjectTeam4 @NegativeCase
 Scenario: Get comments with invalid parameter id
    Given Get comments with invalid parameter id using alphabet "asd"
    When Send request get comments invalid parameter id
    Then Status code should be 400 bad request