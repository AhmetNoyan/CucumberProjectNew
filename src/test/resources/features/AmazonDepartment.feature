#Test case:
#go to amazon.com
#verify that you are on the amazon home page. (verify with title).
#verify dropdown value is by default "All Departments"
#select department Home & Kitchen, and search coffee mug.
#verify you are on coffee mug search results page (use title).
#verify you are in Home & Kitchen department.

Feature: Amazon departments
			
		
	@amazonTest
	Scenario: As a user, I am able to select different deparments and search
		Given I am on the amazon homepage
		And The departments dropdown is "All Deparments"
		When I select the deparments "Home & Kitchen"
		And I search "Coffee mug"
		Then I should be on "Coffee mug" search result page
		And The departments dropdown is "Home & Kitchen"
		
		