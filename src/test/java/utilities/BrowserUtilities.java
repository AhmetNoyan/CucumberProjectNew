package utilities;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtilities {

	Actions action;
	WebDriverWait wait;
	Select letsSelect;
	public void actionsSendKeys(WebElement element,String text) {
		action=new Actions(Driver.getDriver());
		action.sendKeys(element,text).build().perform();
	}
	
	public void actionsClick(WebElement element) {
		action=new Actions(Driver.getDriver());
		action.click(element).build().perform();
	}
	
	public void waitUntilElementVisible(WebElement element) {
		wait=new WebDriverWait(Driver.getDriver(),8);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void waitUntilElementInteractable(WebElement element) {
		wait=new WebDriverWait(Driver.getDriver(),5);
		//wait.until(ExpectedConditions.elementtobe(element));
		
	}
	public void waitUntilElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(Driver.getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	
	public void selectByVisibleText(WebElement selectElement,String tobeSelectedOption) {
		letsSelect=new Select(selectElement);
		letsSelect.deselectByVisibleText(tobeSelectedOption);
		
	}
	
	public String getSelectedOptionn(WebElement selectElement) {
		letsSelect=new Select(selectElement);
		String option=letsSelect.getFirstSelectedOption().getText();
		return option;
	}
	
	public int randomNumber() {
		Random rand = new Random();
		int randomNum = rand.nextInt((999 - 100) + 1) + 100;
		return randomNum;
	}
	
}
