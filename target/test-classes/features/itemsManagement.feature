@regression @itemsTests
Feature: Items Management


  # any steps defined under background will be executed before the first step of each scenarios
  # in the feature file.
  Background: 
    

  @createItem @smoketest
  Scenario: As a user, I am able to create an item or a service
  	Given As an entity user, I am logged in
    And I navigate to Items tab
    When I click on the Add Item button
    Then I should be on item input page
    When I provide item information name "iphone", price 1800, unit "pc", and description "a good iphone"
    And I click Save Item button
    Then The Item is added to the Item list table

  @updateItem
  Scenario: As a user, I am able to update an item or a service
  	Given As an entity user, I am logged in
    And I navigate to Items tab
    When I select the item "iphone"
    And I should be on item details page
    When I update the item price to 80000 dollars
    And I click Update Item button
    Then the Item price is updated to 800 dollars