@forms

Feature: First actions
  Background:
    Given I am logged in
    And I am on the home page
    And I click on AddNew button

  Scenario: See Contact, Event, Quote
    Then I see Contact Us, Event Registration, Quote Request

  Scenario: Contact Us
    When I click on Contact Us label
    Then I see contact fields and check if mandatory

  Scenario: Quote Request
    When I click on Quote Request label
    Then I see quote fields and check if mandatory

  Scenario: Event Registration
    When I click on Event Registration label
    Then I see event fields and check if mandatory

  Scenario: Add additional fields
    When I click on Contact Us label
    And I click on plus button
    And I click additional field
    And I click on done button
    Then I see additional field

  Scenario: Duplicate field
    When I click on Quote Request label
    And I click duplicate button
    Then I see duplicate field

  Scenario: Delete field
    When I click on Event Registration label
    And I click delete button
    Then I do not see deleted field

  Scenario: Edit field
    When I click on Contact Us label
    And I click on edit button
    And I change label info
    And I click on done button
    Then I see label with changed info

  Scenario: Edit field and not save info
    When I click on Contact Us label
    And I click on edit button
    And I change label info
    And I click on done button
    And I click on changes button
    And I click on undo button
    Then I see original fields

  Scenario: Edit field and publish
    When I click on Contact Us label
    And I click on edit button
    And I change label info
    And I click on done button
    And I click on publish button
    Then I see changes