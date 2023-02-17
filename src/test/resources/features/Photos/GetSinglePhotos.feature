Feature: Get Single Photos

  @ProjectTeam4 @PositiveCase
  Scenario Outline: Get single data with registered path id
    Given Get single data with registered path id <id>
    When Send request get single photos
    Then Status code should be 200 OK
    Examples:
      | id |
      | 50 |

  @ProjectTeam4 @NegativeCase
  Scenario Outline: Get single data with unregistered path id
    Given Get single data with unregistered path id <id>
    When Send request get single photos
    Then Status code should be 404 Not Found
    Examples:
      | id   |
      | 5001 |

  @ProjectTeam4 @NegativeCase
  Scenario Outline: Get single data with invalid path special character
    Given Get single data with invalid path special character "<specialChar>"
    When Send request get single photos
    Then Status code should be 400 Bad Request
    Examples:
      | specialChar |
      | #@$%&       |

  @ProjectTeam4 @NegativeCase
  Scenario Outline: Get single data with invalid path alphabet
    Given Get single data with invalid path alphabet "<alphabet>"
    When Send request get single photos
    Then Status code should be 400 Bad Request
    Examples:
      | alphabet |
      | xxxxxxx  |

  @ProjectTeam4 @NegativeCase
  Scenario: Get single data without path id
    Given Get single data without path id
    When Send request get single photos without path id
    Then Status code should be 200 OK
