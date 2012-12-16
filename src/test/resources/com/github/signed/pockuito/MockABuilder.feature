Feature: As a developer I want to create a mock for a builder class/interface easily

  Scenario: response on a detail collecting method call
    Given  a SimpleBuilder that constructs an ObjectUnderConstruction
    And I created a mock for the SimpleBuilder
    When I invoke a method that has SimpleBuilder as return type
    Then the mock returns itself


