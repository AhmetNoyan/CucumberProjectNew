@regression @itemsTests
Feature: Items Management


  # any steps defined under background will be executed before the first step of each scenarios
  # in the feature file.
  Background: 
    Given As an entity user, I am logged in
    And I navigate to Items tab

  @createItemWithTable @smoketest
  Scenario: As a user, I am able to create an item or a service	
    When I click on the Add Item button
    Then I should be on item input page
    When I provide item information to the field 
   	|iphone|1800|pc|a good iphone|
    And I click Save Item button
    Then The Item is added to the Item list table

  @updateItem
  Scenario: As a user, I am able to update an item or a service
    When I select the item "iphone"
    And I should be on item details page
    When I update the item price to 80000 dollars
    And I click Update Item button
    Then the Item price is updated to 800 dollars
    
   @deleteItem 
   Scenario: As a user, I am able to delete an item
   	When I click on the Add Item button
   	Then I should be on item input page
   	When I create an item with following information
   	|food|3|dz|some description|
   	Then The Item is added to the Item list table
   	When I delete the item created above
   	Then The item is no longer in the items list table
   
    