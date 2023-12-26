package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtilities;
import utilities.Driver;

public class ItemsPage {
	
	
	public ItemsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	BrowserUtilities utils=new BrowserUtilities();
	
	@FindBy(xpath="//button[text()=' Add Item']")
	public WebElement addItemButton;
	
	@FindBy(xpath="//h3[text()='Items']")
	public WebElement itemsPageHeaderText;
	
	@FindBy(xpath="//h3[text()='New Item']")
	public WebElement addItemPageHeaderText;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	public WebElement nameInput;
	
	@FindBy(xpath="//div[text()='Price ']//parent::label//following-sibling::div/input")
	public WebElement priceInput;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	public WebElement unitField;
	
	@FindBy(xpath="//textarea[@name='description']")
	public WebElement description;
	
	@FindBy(xpath="//span[text()='pc']")
	public WebElement addItem_pc_Unit;
	
	@FindBy(xpath="//span[text()='%s']")
	public WebElement unitOptions;
	
	@FindBy(xpath="//button[text()=' Save Item']")
	public WebElement saveItemButton;
	
	@FindBy(xpath="//h3[text()='Edit Item']")
	public WebElement editItemHeaderText;
	
	@FindBy (xpath = "//button[text()=' Update Item']")
	public WebElement updateButton;
	
	@FindBy (xpath = "//button[text()='Filter ']")
	public WebElement filterButton;
	
	@FindBy(name="name")
	public WebElement filterNameBox;
	
	@FindBy(xpath="//a[text()='%s']")
	public WebElement itemsNameInTheTable;
	
	@FindBy(xpath = "(//button[contains(@id, 'headlessui')])[3]")
	public WebElement filterItem3dot;
	
	@FindBy (xpath = "//a[text()=' Delete']")
	public WebElement filter3dotDeleteBtn;
	
	@FindBy (xpath = "//button[text()='Ok']")
	public WebElement itemDeleteOkayBtn;
	
	@FindBy (xpath = "//span[text()='No Results Found']")
	public WebElement filterNoResultFoundMessage;
	
	
	public void createAnItem(String itemName, String itemPrice, String itemUnit, String itemDes) {
		nameInput.sendKeys(itemName);
		priceInput.sendKeys(itemPrice.toString());
		unitField.click();
		utils.waitUntilElementVisible(addItem_pc_Unit);
//		unitOptions.findElement(
//				By.xpath(String.format(unitOptions.getAttribute("xpath"), itemUnit))).click();
		Driver.getDriver().findElement(By.xpath("//span[text()='"+itemUnit+"']")).click();
		description.sendKeys(itemDes);
		saveItemButton.click();
	}
	
	public void deleteAnItem(String name) throws InterruptedException {
		 filterButton.click();
		 utils.waitUntilElementVisible(filterNameBox);
		 utils.actionsSendKeys(filterNameBox, name);
//		 itemsNameInTheTable.findElement(
//				 By.xpath(String.format(itemsNameInTheTable.getAttribute("xpath"), name))).isDisplayed();
		 Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[text()='"+name+"']")).isDisplayed());
		 utils.waitUntilElementVisible(filterItem3dot);
		 Thread.sleep(2000);
		 filterItem3dot.click();
		 utils.waitUntilElementVisible(filter3dotDeleteBtn);
		 filter3dotDeleteBtn.click();
		 utils.waitUntilElementVisible(itemDeleteOkayBtn);
		 itemDeleteOkayBtn.click();
	}
	
}
