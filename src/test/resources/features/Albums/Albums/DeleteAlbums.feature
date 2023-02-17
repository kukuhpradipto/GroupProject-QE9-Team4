Feature: Albums Delete Id API Automation Testing
  @ProjectTeam4 @PositiveCase
  Scenario: Delete single data album with valid id parameter
    Given Delete single data album with valid id parameter 1
    When Send request delete data album with id
    Then Response status code should be 200 OK
    And Validator delete data album json schema valid json

  @ProjectTeam4 @NegativeCase
  Scenario Outline: Delete single data album with invalid id parameter
    Given Delete single data album with invalid parameter "<id>"
    When Send request delete data album with invalid id
    Then Response status code should be 400 Bad Request
    Examples:
      | id   |
      | #%$* |
      | xyz  |

  @ProjectTeam4 @NegativeCase
  Scenario Outline: Delete single data album with unregistered id
    Given Delete single data album with unregistered id <id>
    When Send request delete data album with id
    Then Response status code should be 404 Not Found
    Examples:
      | id   |
      | 101  |
      | 2000 |

  @ProjectTeam4 @NegativeCase
  Scenario: Delete single data album with id 0
    Given Delete single data album with id 0
    When Send request delete data album with id
    Then Response status code should be 404 Not Found

  @ProjectTeam4 @NegativeCase
  Scenario: Delete single data album without id parameter
    Given Delete single data album without id parameter
    When Send request delete data album with id without id
    Then Response status code should be 404 Not Found
    And Validator delete user json schema without parameter id