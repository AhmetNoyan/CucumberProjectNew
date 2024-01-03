package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.LogInPage;
import utilities.BrowserUtilities;
import utilities.DataReader;
import utilities.Driver;

public class UserManagementSteps {
	LogInPage loginPage = new LogInPage();
	BrowserUtilities utils=new BrowserUtilities();
	String emailAddress;
	String passwordInput;
	@Given("As a user, I am on the login page")
	public void as_a_user_i_am_on_the_login_page() {
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
	}

	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {
		utils.actionsSendKeys(loginPage.emailField, DataReader.getProperty("username"));
		utils.actionsSendKeys(loginPage.passwordField, DataReader.getProperty("password"));		
		//loginPage.emailField.sendKeys(DataReader.getProperty("username"));
		//loginPage.passwordField.sendKeys(DataReader.getProperty("password"));
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
		loginPage.loginBtn.click();
	}

	@Then("I should be on user profile page")
	public void i_should_be_on_user_profile_page() {
		Assert.assertTrue(loginPage.accountSettingsHeader.isDisplayed());
	   
	}
	
	//invalid login scenarios steps
	
	@When("I enter invalid username and valid password")
	public void i_enter_invalid_username_and_valid_password() {
	    utils.actionsSendKeys(loginPage.emailField , DataReader.getProperty("invalidUserName"));
	    emailAddress=DataReader.getProperty("username");
	    utils.actionsSendKeys(loginPage.passwordField, DataReader.getProperty("password"));
	    passwordInput=DataReader.getProperty("invalidPassword");
	}
	@Then("I should see an error message")
	public void i_should_see_an_error_message() {
		if (emailAddress.equals("") || passwordInput.equals("")) {
			utils.waitUntilElementVisible(loginPage.fieldIsRequiredMessage);
			Assert.assertTrue(loginPage.fieldIsRequiredMessage.isDisplayed());
		} else {
			utils.waitUntilElementVisible(loginPage.invalidLoginErrorMessage);
			Assert.assertTrue(loginPage.invalidLoginErrorMessage.isDisplayed());
		}
	}
	@Then("I should not be logged in")
	public void i_should_not_be_logged_in() {
		Assert.assertTrue(loginPage.emailField.isDisplayed());
	}
	@When("I enter valid username and invalid password")
	public void i_enter_valid_username_and_invalid_password() {
		utils.actionsSendKeys(loginPage.emailField , DataReader.getProperty("username"));
		emailAddress=DataReader.getProperty("username");
	    utils.actionsSendKeys(loginPage.passwordField, DataReader.getProperty("invalidPassword"));
	    passwordInput=DataReader.getProperty("invalidPassword");
	}
	
	//Scenario outline steps
	@When("I enter email {string} and password {string}")
	public void i_enter_email_and_password(String email, String password) {
		emailAddress = email;
		passwordInput = password;
	    utils.actionsSendKeys(loginPage.emailField, email);
	    utils.actionsSendKeys(loginPage.passwordField, password);
		
	}
	
	
	
}
