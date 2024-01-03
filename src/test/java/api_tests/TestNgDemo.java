package api_tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LogInPage;
import pages.SauceDemoPage;
import utilities.DataReader;
import utilities.Driver;

public class TestNgDemo {
	SauceDemoPage page;
	LogInPage login;
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest Method");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After test method");
	}
	@BeforeMethod
	//once before each test
	public void beforeMethod() {
		System.out.println("before method");
	}
	
	
	
	@Test(groups="smoketest")
	public void assertionDemo() {
		//Hard assert, if condition fails, it stops the execution of the code
		Assert.assertEquals(false, false);
		System.out.println("testng check");
	}
	@Test(description="softassertion test method",groups="smoketest")
	public void softAssertion() {
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(false, true);
		System.out.println("it should print this message");
		softassert.assertAll();
	}
	@Test(priority=0,description="first method to run",groups="smoketest",dependsOnMethods="assertionDemo")
	public void uiTestDemo() {
		page = new SauceDemoPage();
		//Test case 1go to https://saucedemo.com
		Driver.getDriver().get("https://saucedemo.com");
		//log in with valid username = standard_user   
		page.username.sendKeys("standard_user");
		//password = secret_sauceVerify that you are logged in successfully.
		page.password.sendKeys("secret_sauce");
		page.loginbtn.click();
		Assert.assertEquals(page.inventoryItems.size(), 6);
	}
	@Test(groups="smoketest")
	public void uiTestDemo1() {
		//Test case 1go to https://saucedemo.com
		login=new LogInPage();
		Driver.getDriver().get("http://crater.primetech-apps.com/login");
		//log in with valid username = standard_user   
		login.emailField.sendKeys(DataReader.getProperty("username"));
		//password = secret_sauceVerify that you are logged in successfully.
		login.passwordField.sendKeys(DataReader.getProperty("password"));
		login.loginBtn.click();
		//Assert.assertEquals(page.inventoryItems.size(), 6);
	}
}
