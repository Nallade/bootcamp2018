@task2
Feature: Testing of list of persons with job
  Background:
    Given I am on task page jobs

    Scenario: add new person
      When I click add button
      And I enter person info:
        | name | Ann  |
        | job  | cook |
      And I click other add button
      And I check person on list

    Scenario: edit person
      When I click edit button
      And I enter person info:
        | name | Tom     |
        | job  | manager |
      Then I click other add button

    Scenario Outline: add other person
      When I click add button
      And I enter person info:
        | name | <name>  |
        | job  | <job>   |
      Then I click other add button
      @working
        Examples:
          | name  | job       |
          | Lulu  | tester    |
          | Ruth  | assistant |

    Scenario: edit person and cancel
      When I click edit button
      And I enter person info:
        | name | Tom     |
        | job  | manager |
      Then I click cancel button

    Scenario: delete person
      When I click delete

    Scenario: reset the list
      When I click add button
      And I enter person info:
        | name | Tom     |
        | job  | manager |
      And I click other add button
      And I click reset button
      And I click edit button
      And I enter person info:
        | name | Sany   |
        | job  | driver |
      And I click other add button
      And I click reset button
      And I click delete
      Then I click reset button

