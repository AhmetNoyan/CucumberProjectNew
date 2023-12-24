package step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import pages.AmazonPage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class AmazonSteps {
	
	AmazonPage amazon=new AmazonPage();
	BrowserUtilities utils=new BrowserUtilities();
	
	@Given("I am on the amazon homepage")
	public void i_am_on_the_amazon_homepage() {
		Driver.getDriver().get("https://amazon.com");
		String homeTitle=Driver.getDriver().getTitle();
		Assert.assertEquals(homeTitle, "Amazon.com");
		
	}
	@Given("The departments dropdown is {string}")
	public void the_departments_dropdown_is(String defaultOption) {
	    Assert.assertEquals(utils.getSelectedOptionn(amazon.departmentsDropdown), defaultOption);
	}
	@When("I select the deparments {string}")
	public void i_select_the_deparments(String optionSelected) {
	    utils.selectByVisibleText(amazon.departmentsDropdown, optionSelected);
	}
	@When("I search {string}")
	public void i_search(String searchItem) {
	    utils.actionsSendKeys(amazon.searchField, searchItem+Keys.ENTER);
	    
	}
	@Then("I should be on {string} search result page")
	public void i_should_be_on_search_result_page(String searchedItem) {
	    String searchTitle=Driver.getDriver().getTitle();
	    Assert.assertTrue(searchTitle.contains(searchTitle));
	}
	
}
