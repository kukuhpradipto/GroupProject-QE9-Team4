Feature: Todos Put Create API Automation Testing

  Scenario: Put update user with valid json parameter
    Given Put update user with valid json in id 1
    When Send request put update user
    Then Response status code should be 200 Oke
    And Response body should be title userId is 5, title is "qui ullam ratione quibusdam voluptatem quia omnis"
    And Validate put json schema valid json