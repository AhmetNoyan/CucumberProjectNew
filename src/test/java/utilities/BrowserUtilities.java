package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BrowserUtilities {

	Actions action;
	public void actionsSendKeys(WebElement element,String text) {
		action=new Actions(Driver.getDriver());
		action.sendKeys(element,text).build().perform();
	}
}
