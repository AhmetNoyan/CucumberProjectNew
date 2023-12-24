package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class ItemsPage {
	public ItemsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
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
	
	@FindBy(xpath="//button[text()=' Save Item']")
	public WebElement saveItemButton;
}
