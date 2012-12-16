Feature:
  In order to avoid stubbing all the method calls of a builder class/interface myself
  As a developer
  I want to tell Pockuito to create a mock of o builder for me

  Background:
    Given a SimpleBuilder that constructs an ObjectUnderConstruction
    And I create a mock for the SimpleBuilder

  Scenario: response on a detail collecting method call
    When I invoke a method on the mock that has SimpleBuilder as return type
    Then the mock returns itself

  Scenario: response on a creation method call
    When I invoke the build method on the mock
    Then the mock returns a mock of the methods return type