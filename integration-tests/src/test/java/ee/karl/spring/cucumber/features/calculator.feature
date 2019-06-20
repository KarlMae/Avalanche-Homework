Feature: As a user, I want to use the calculator

  Scenario: I enter 2 numbers and hit calculate
    Given I am on the calculator page
    And I enter "10" as number 1
    And I enter "5" as number 2
    When I press the calculate button
    Then I should see "15" as output

  Scenario: I select subtraction, enter numbers and hit calculate
    Given I am on the calculator page
    And I enter "10" as number 1
    And I enter "5" as number 2
    And I press the "sub" operation button
    When I press the calculate button
    Then I should see "5" as output

  Scenario: I select multiplication, enter numbers and hit calculate
    Given I am on the calculator page
    And I enter "10" as number 1
    And I enter "5" as number 2
    And I press the "prod" operation button
    When I press the calculate button
    Then I should see "50" as output

  Scenario: I select division, enter numbers and hit calculate
    Given I am on the calculator page
    And I enter "10" as number 1
    And I enter "5" as number 2
    And I press the "div" operation button
    When I press the calculate button
    Then I should see "2" as output

  Scenario: I press the history button and see the modal
    Given I am on the calculator page
    And I press the history button
    Then I should see the modal

  Scenario: I haven't pressed the history modal and don't see the modal
    Given I am on the calculator page
    Then I should not see the modal

  Scenario: I enter numbers and history has results
    Given I am on the calculator page
    And I enter "1" as number 1
    And I enter "1" as number 2
    And I press the calculate button
    And I press the history button
    Then History modal should have results

  Scenario: I calculate and last row of history table should be correct
    Given I am on the calculator page
    And I enter "10" as number 1
    And I enter "5" as number 2
    And I press the "sub" operation button
    And I press the calculate button
    When I press the history button
    Then Last item in the table should be "Subtraction", "10", "5" ,"5"
