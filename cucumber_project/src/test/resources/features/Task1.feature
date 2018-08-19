
Feature: Introduction to cucumber
  As a test engineer
  I want to be able to write and execute a scenarios and scenario outlines
  Background:
    Given I am on feedback page

  Scenario: one language
    When I select one language
    And I click send
    Then I see feedback: "Your language: English"
    
  Scenario: two language
    When I select two languages
    And I click send
    Then I see feedback: "Your language: English,French"

  Scenario Outline: end message
    When I input name: <name>
    And I click send
    And I click green button
    Then  I see notification: <notification>
  @working
    Examples:
      | name | notification                       |
      | Ann  | Thank you, Ann, for your feedback! |
      | Tom  | Thank you, Tom, for your feedback! |
      |      | Thank you for your feedback!       |

    Scenario: feedback
      When I enter data:
        | name | Ann |
        | age  | 52  |
      And I click send
      Then I see text:
        | name | Ann |
        | age  | 52  |

  @task4
  Scenario Outline: feedback2
    When I enter data:
      | name | <name> |
      | age  | <age>  |
    And I click send
    And I click green button
    Then I see text like this: "<message>"
    Examples:
      | name | age | message                            |
      | Ann  | 52  | Thank you, Ann, for your feedback! |
      | Tom  | 61  | Thank you, Tom, for your feedback! |
      |      |     |Thank you for your feedback!        |