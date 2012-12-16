Feature:
  In order to avoid stubbing all the method calls of a builder class/interface myself
  As a developer
  I want to tell Pockuito to create a mock of o builder for me

  Background:
    Given a SimpleBuilder that constructs an ObjectUnderConstruction

  Scenario: response on a detail collecting method call
    And I create a mock for the SimpleBuilder
    When I invoke a method on the mock that has SimpleBuilder as return type
    Then the mock returns itself

  Scenario: response on a creation method call
    And I create a mock for the SimpleBuilder
    When I invoke the build method on the mock
    Then the mock returns a mock of the methods return type

  Scenario: respond with a pre defined object when the creation method is called
    And I create a mock for the SimpleBuilder with a defined ObjectUnderConstruction
    When  I invoke the build method on the mock
    Then the predefined ObjectUnderConstruction is returned