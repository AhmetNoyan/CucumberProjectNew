package step_definitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.CreaterCommonPage;
import pages.ItemsPage;
import pages.LogInPage;
import utilities.BrowserUtilities;
import utilities.DataReader;
import utilities.Driver;

public class ItemsManagementSteps {

	LogInPage loginPage = new LogInPage();
	ItemsPage itemsPage = new ItemsPage();
	CreaterCommonPage commonPage = new CreaterCommonPage();
	BrowserUtilities utils = new BrowserUtilities();
	static String itemName;

	@Given("As an entity user, I am logged in")
	public void as_an_entity_user_i_am_logged_in() {
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		loginPage.login();
	}

	@Given("I navigate to Items tab")
	public void i_navigate_to_items_tab() {
		commonPage.itemsLink.click();
		Assert.assertTrue(itemsPage.itemsPageHeaderText.isDisplayed());
	}

	@When("I click on the Add Item button")
	public void i_click_on_the_add_item_button() {
		itemsPage.addItemButton.click();

	}

	@Then("I should be on item input page")
	public void i_should_be_on_item_input_page() {
		Assert.assertTrue(itemsPage.addItemPageHeaderText.isDisplayed());
	}

	@When("I provide item information name {string}, price {int}, unit {string}, and description {string}")
	public void i_provide_item_information_name_price_unit_and_description(String name, Integer price, String unit,
			String description) {
		itemName = name+utils.randomNumber();
		System.out.println("itemName that has been created: "+itemName);
		itemsPage.nameInput.sendKeys(itemName);
		itemsPage.priceInput.sendKeys(price.toString());
		itemsPage.unitField.click();
		utils.waitUntilElementVisible(itemsPage.addItem_pc_Unit);
		Driver.getDriver().findElement(By.xpath("//span[text()='"+unit+"']")).click();
		itemsPage.description.sendKeys(description);

	}

	@When("I click Save Item button")
	public void i_click_save_item_button() {
		itemsPage.saveItemButton.click();
	}

	@Then("The Item is added to the Item list table")
	public void the_item_is_added_to_the_item_list_table() throws InterruptedException {
		Thread.sleep(3000);
		utils.waitUntilElementVisible(itemsPage.filterButton);
		utils.actionsClick(itemsPage.filterButton);
		utils.waitUntilElementVisible(itemsPage.filterNameBox);
		System.out.println("itemName for list table check: "+itemName);
		utils.actionsSendKeys(itemsPage.filterNameBox, itemName);
		//itemsPage.filterNameBox.sendKeys(itemName);
		Assert.assertTrue(
				Driver.getDriver().findElement(By.xpath("//a[text()='"+itemName+"']")).isDisplayed());}

	// UPDATE ITEM SCENARIO STEPS

	@When("I select the item {string}")
	public void i_select_the_item(String name) {
		Driver.getDriver().findElement(By.xpath("//a[text()='" + itemName + "']")).click();
	}

	@When("I should be on item details page")
	public void i_should_be_on_item_details_page() {
		Assert.assertTrue(itemsPage.editItemHeaderText.isDisplayed());
	}

	@When("I update the item price to {int} dollars")
	public void i_update_the_item_price_to_dollars(Integer price) {
		itemsPage.priceInput.clear();
		itemsPage.priceInput.sendKeys(price.toString());

	}

	@When("I click Update Item button")
	public void i_click_update_item_button() {
		itemsPage.updateButton.click();

	}

	@Then("the Item price is updated to {int} dollars")
	public void the_item_price_is_updated_to_dollars(Integer updatedPrice) {
		String itemXpath = "(//a[text()='"+itemName+"']//parent::td//following-sibling::td)[2]//span";
		String itemPrice = Driver.getDriver().findElement(By.xpath(itemXpath)).getText();
		System.out.println(itemPrice);
		String trimmedPrice = itemPrice.substring(2);
		Assert.assertEquals(trimmedPrice, updatedPrice + ".00");
	}
	
	//DataTable has been added to steps
	@When("I provide item information to the field")
	public void i_provide_item_information_to_the_field(DataTable dataTable) {
	   List<String> itemInfo= dataTable.asList();
	   itemsPage.nameInput.sendKeys(itemInfo.get(0));
	   itemName=itemInfo.get(0);
	   itemsPage.priceInput.sendKeys(itemInfo.get(1));
	   itemsPage.unitField.click();
	   utils.waitUntilElementVisible(itemsPage.addItem_pc_Unit);
	   Driver.getDriver().findElement(By.xpath("//span[text()='"+itemInfo.get(2)+"']")).click();
	   
	   itemsPage.description.sendKeys(itemInfo.get(3));
	}
	//Item delete Scenario
	@When("I create an item with following information")
	public void i_create_an_item_with_following_information(DataTable dataTable) {
	    List<String> itemInfo=dataTable.asList();
	    itemName=itemInfo.get(0)+utils.randomNumber();
	    itemsPage.createAnItem(itemName, itemInfo.get(1), itemInfo.get(2), itemInfo.get(3));
	}
	@When("I delete the item created above")
	public void i_delete_the_item_created_above() throws InterruptedException {
		itemsPage.deleteAnItem(itemName);
	}
	@Then("The item is no longer in the items list table")
	public void the_item_is_no_longer_in_the_items_list_table() throws InterruptedException {
		Thread.sleep(2000);
		if (!itemsPage.filterNameBox.isDisplayed()) {
			utils.waitUntilElementToBeClickable(itemsPage.filterButton);
			utils.actionsClick(itemsPage.filterButton);
			utils.waitUntilElementVisible(itemsPage.filterNameBox);
			utils.actionsSendKeys(itemsPage.filterNameBox, itemName);
		}
		utils.waitUntilElementVisible(itemsPage.filterNoResultFoundMessage);
		Assert.assertTrue(itemsPage.filterNoResultFoundMessage.isDisplayed());
	}
	
	
	
	
}
