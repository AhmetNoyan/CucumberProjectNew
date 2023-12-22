
@login @regression
Feature: Creater app user management
  User with permission should be able 
  interact with the application on seccessful login 

  @validlogin @smokeTest
  Scenario: Successful login
    Given As a user, I am on the login page
    When I enter valid username and valid password
    And I click on login button
    Then I should be on user profile page
    
  @invalidlogin   
  Scenario: Invalid username login
   	Given As a user, I am on the login page
   	When I enter invalid username and valid password
   	And I click on login button
   	Then I should see an error message
   	And I should not be logged in
    

