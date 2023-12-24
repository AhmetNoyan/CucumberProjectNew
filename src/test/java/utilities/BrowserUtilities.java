package utilities;

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
	
	public void waitUntilElementVisible(WebElement element) {
		wait=new WebDriverWait(Driver.getDriver(),5);
		wait.until(ExpectedConditions.visibilityOf(element));
		
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
	
}
