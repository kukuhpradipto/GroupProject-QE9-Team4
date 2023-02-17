Feature: Albums Get Id API Automation Testing
  @ProjectTeam4 @PositiveCase
  Scenario: Get single data album with valid id parameter
    Given Get single data album with valid id parameter 1
    When Send request get data with id
    Then Response status code should be 200 OK
    And Response body should be id 1 and userId 1
    And Validator get user json schema with valid parameter id

 @ProjectTeam4 @NegativeCase
  Scenario Outline: Get single data album with invalid id parameter
    Given Get single data album with invalid parameter "<id>"
    When Send request get data with invalid id
    Then Response status code should be 404 Not Found
    Examples:
      | id   |
      | #%$* |
      | xyz  |

  @ProjectTeam4 @NegativeCase
  Scenario Outline: Get single data album with unregistered id
    Given Get single data album with unregistered id <id>
    When Send request get data with id
    Then Response status code should be 404 Not Found
    Examples:
     | id   |
     | 101  |
     | 2000 |

  @ProjectTeam4 @NegativeCase
  Scenario: Get single data album with id 0
    Given Get single data album with id 0
    When Send request get data with id
    Then Response status code should be 404 Not Found

  @ProjectTeam4 @NegativeCase
  Scenario: Get single data album without id parameter
    Given Get single data album without id parameter
    When Send request get data without id
    Then Response status code should be 200 OK
    And Validator get user json schema without parameter id


