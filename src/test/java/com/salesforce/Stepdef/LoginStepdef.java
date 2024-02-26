package com.salesforce.Stepdef;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.apache.logging.log4j.Logger;

import com.salesforcce.pages.createOpty.CreateOptyPage;
import com.salesforce.pages.contacts.ContactsPage;
import com.salesforce.pages.home.HomePage;
import com.salesforce.pages.leads.LeadsPage;
import com.salesforce.pages.login.LoginPage;
import com.salesforce.utilities.Constants;
import com.salesforce.utilities.Log4JUtility;
import com.salesforce.utilities.PropertiesUtility;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepdef {
	protected static Logger log;
	public  WebDriver driver;
	protected static Log4JUtility logObject=Log4JUtility.getInstance();
	LoginPage login;
	HomePage home;
	LeadsPage leads;
	ContactsPage contacts;
	CreateOptyPage opty;
	
	
	public  void launchBrowser(String browserName) {
		switch(browserName) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
			break;
		case "chrome":
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
			
			break;
		}
		System.out.println(browserName+" browser opened");
	}
	
	public WebDriver getDriver() {
		return driver;
	}
   
	
	public  void goToUrl(String url) {
		driver.get(url);
		log.info(url+ "is entered");
	}

	public  void closeBrowser() {
		driver.close();
		log.info("current browser closed");
	}
	
	@BeforeAll
	public static void setUpBeforeAllScenarios() {
		log=logObject.getLogger();
	}
	@Before
	public void setUpEachScenario() {
		
		launchBrowser("chrome");
		
	}
	@After
	public void tearDown() {
		closeBrowser();
	}
//	@AfterStep
//	public void after_each_step(Scenario sc) {
//		if(sc.isFailed()){
//			
//		}
//	}
	
	@Given("the salesforce url")
	public void the_salesforce_url() {
		PropertiesUtility pro = new PropertiesUtility();
	    Properties appprop=pro.loadFile("applicationDataProperties");
	   String url = appprop.getProperty("url");
	   goToUrl(url);
	}

	
	@When("user on {string}")
	public void user_on(String page) {
	    if(page.trim().equalsIgnoreCase("loginpage")) {
	    	login = new LoginPage(driver);
	    }
	    else {
	    	if(page.trim().equalsIgnoreCase("homepage")) {
	    		home = new HomePage(driver);
	    	}
	    	else {
	    		if(page.trim().equalsIgnoreCase("leadspage")) {
	    			leads = new LeadsPage(driver);
	    		}
	    		else {
	    			if(page.trim().equalsIgnoreCase("ContactsPage")) {
	    				contacts = new ContactsPage(driver);
	    			}	
	    		else {
	    			if(page.trim().equalsIgnoreCase("CreateOptyPage")) {
	    				opty = new CreateOptyPage(driver);
	    			}
	    			
	    		}
	    	}
	    		
	   }
	    	
	 }
	}


	@When("i enter the username as")
	public void i_enter_the_username_as() throws InterruptedException {
		Thread.sleep(2000);
		PropertiesUtility pro = new PropertiesUtility();
	    Properties appprop=pro.loadFile("applicationDataProperties");
	    String username = appprop.getProperty("username");
	    System.out.println("Application Data Property : username = "+ username);
		login.enterUserName(username);
		Thread.sleep(3000);
	}

	@When("i enter the password as {string}")
	public void i_enter_the_password_as(String password) {
		login.enterPassword(password);
	}

	@When("i click on the login button")
	public void i_click_on_the_login_button() {
		login.clickLoginButton();
	}

	@Then("i should see the login error message")
	public void i_should_see_the_login_error_message() {
	   String ExpectedError = "Please enter your password.";
	   String ActualError = login.getLoginErrorMsg();
	   Assert.assertEquals(ActualError,ExpectedError);
	}

	@When("i enter the username as {string}")
	public void i_enter_the_username_as(String username) throws InterruptedException {
	    Thread.sleep(3000);
	    login.enterUserName(username);
	}

	@Then("i should see the homepage")
	public void i_should_see_the_homepage() {
	    String ExpectedTitle = "Home Page ~ Salesforce - Developer Edition";
	    String ActualTitle = login.getPageTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	@When("i select the remember username text box")
	public void i_select_the_remember_username_text_box() {
	    login.clickRememberMeButton();
	}

	@Then("i click on the usermenudropdown")
	public void i_click_on_the_usermenudropdown() {
	    home.ClickdropDown();
	}

	@Then("i select logout button")
	public void i_select_logout_button() throws InterruptedException {
	    home.clickLogOut();
	    Thread.sleep(3000);
	}

	@Then("i should see the username on the username textbox field")
	public void i_should_see_the_username_on_the_username_textbox_field() {
		String ExpectedUsername ="priya@tekarch.com";	
		String ActualUsername =login.getUserNameFieldText();
		Assert.assertEquals(ActualUsername, ExpectedUsername);
	}
	
	@When("i click on the forgot password button")
	public void i_click_on_the_forgot_password_button() throws InterruptedException {
		Thread.sleep(3000);
	    login.forgetPasswordLink();
	}
	

	@Then("i should see the forgot password page")
	public void i_should_see_the_forgot_password_page() {
		String ExpectedMsg = "Forgot Your Password";
		String ActualMsg = login.getForgotPasswordMsg();
		Assert.assertEquals(ActualMsg, ExpectedMsg);
	}
	
	@When("i enter the username on forgot password page as {string}")
	public void i_enter_the_username_on_forgot_password_page_as(String username) {
	    login.enterUserNameInForgotPage(username);
	}


	@When("i click on the continue button")
	public void i_click_on_the_continue_button() {
	    login.clickContinueButton();
	}

	@Then("i should see password reset page with email associated with the username")
	public void i_should_see_password_reset_page_with_email_associated_with_the_username() {
		String ExpectedEmailError = "Check Your Email";
		String ActualEmailError = login.getEmailError();
		Assert.assertEquals(ActualEmailError, ExpectedEmailError);
	}
	

	@When("i enter the wrong username as {string}")
	public void i_enter_the_wrong_username_as(String username) {
	    login.enterUserName(username);
	}
	
	@When("i enter wrong password as {string}")
	public void i_enter_wrong_password_as(String password) {
	    login.enterPassword(password);
	}
	
	@Then("i should see the error message")
	public void i_should_see_the_error_message() {
		String ExpectedLoginError = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String ActualLoginError = login.getInvalidLoginErrorMsg();
		Assert.assertEquals(ActualLoginError, ExpectedLoginError);
	}



}
