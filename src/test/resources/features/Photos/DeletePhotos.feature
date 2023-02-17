Feature: Delete Photos

  @ProjectTeam4 @PositiveCase
  Scenario Outline: Delete photos with valid parameter id
    Given Delete photos with valid parameter id <id>
    When Send request get single photos
    Then Status code should be 200 OK
    Examples:
      | id |
      | 1  |

  @ProjectTeam4 @NegativeCase
  Scenario Outline: Delete photos with unregister path id
    Given Delete photos with unregister path id <id>
    When Send request get single photos
    Then Status code should be 404 Not Found
    Examples:
      | id    |
      | 99999 |

  @ProjectTeam4 @NegativeCase
  Scenario Outline: Delete photos with invalid parameter special character
    Given Delete photos with invalid path special character "<specialChar>"
    When Send request get single photos
    Then Status code should be 400 Bad Request
    Examples:
      | specialChar |
      | !@#$%       |

  @ProjectTeam4 @NegativeCase
  Scenario Outline: Delete photos with invalid parameter alphabet
    Given Delete photos with invalid path alphabet "<alphabet>"
    When Send request get single photos
    Then Status code should be 400 Bad Request
    Examples:
      | alphabet |
      | qwerty   |

  @ProjectTeam4 @NegativeCase
  Scenario: Delete photos without parameter id
    Given Delete photos without parameter id
    When Send request get single photos without path id
    Then Status code should be 404 Not Found
