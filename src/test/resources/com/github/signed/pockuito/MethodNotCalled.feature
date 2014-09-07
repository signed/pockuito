Feature:
  In order to avoid duplication
  As a developer
  I want a direct way to verify a method on a mock was not called

  Background:
    Given a mock

  Scenario: fail if the method was called
    And I call the method
    When I verify that the method was not called
    Then the verification fails

  Scenario: succeed if the method was not call
    When I verify that the method was not called
    Then the verification succeeds

  Scenario: succeed if another method was called
    And I call another method
    When I verify that the method was not called
    Then the verification succeeds
