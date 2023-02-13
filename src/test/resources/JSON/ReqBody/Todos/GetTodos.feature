Feature: Todos Get Id API Automation Testing

  Scenario: Get single user with valid id parameter
    Given Get user with valid id parameter 1
    When Send request get user with id
    Then Response status code should be 200 Oke
    And Response body should be id 1 and userId 1
    And Validator get user json schema wit valid parameter id


