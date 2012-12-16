Feature: As a developer I want to create a mock for a builder class/interface easily

  Scenario: response on a detail collecting method call
    Given a SimpleBuilder that constructs an ObjectUnderConstruction
    And I create a mock for the SimpleBuilder
    When I invoke a method on the mock that has SimpleBuilder as return type
    Then the mock returns itself


