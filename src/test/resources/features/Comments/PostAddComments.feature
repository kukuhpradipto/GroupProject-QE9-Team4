Feature: Post Add Comments

@ProjectTeam4 @PositiveCase
Scenario: Post add comments with valid json
  Given Post add comments with valid json
  When Send request post add comments
  Then Status code should be 201 created
  And Response body should be contain name "quo vero reiciendis velit similique earum" and email is "Jayne_Kuhic@sydney.com"
  And Validate post add comments json schema

@ProjectTeam4 @NegativeCase
  Scenario: Post add comments with invalid json
  Given Post add comments with invalid json
  When Send request post add comments invalid
  Then Status code should be 400 bad request



