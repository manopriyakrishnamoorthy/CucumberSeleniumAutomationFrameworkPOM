package com.salesforce.Stepdef;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactsStepdef {
	private LoginStepdef loginstepdef;
	WebDriver driver;
	 // PicoContainer injects class ContextSteps
	public ContactsStepdef(LoginStepdef loginstepdef) {
		this.loginstepdef = loginstepdef;
		driver = loginstepdef.getDriver();
	}
	
	@When("i click contacts tab")
	public void i_click_contacts_tab() {
	    loginstepdef.home.clickContactTab();
	}

	@Then("i should see contact home page")
	public void i_should_see_contact_home_page() {
		String ExpectedTitle = "Contacts: Home ~ Salesforce - Developer Edition";
		String ActualTitle = loginstepdef.home.getPageTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

	@When("i click on new button")
	public void i_click_on_new_button() {
	    loginstepdef.contacts.clickNewButton();
	}

	@Then("i should see new contact home page")
	public void i_should_see_new_contact_home_page() {
	    loginstepdef.contacts.clickNewButton();
	}

	@When("i enter last name in last name field")
	public void i_enter_last_name_in_last_name_field() {
	    loginstepdef.contacts.enterLastName("geetha");
	}

	@When("i enter the account name in account name field")
	public void i_enter_the_account_name_in_account_name_field() {
	    loginstepdef.contacts.enterAccount("priya krishna");
	}

	@When("i click on the save button in contact page")
	public void i_click_on_the_save_button_in_contact_page() {
	    loginstepdef.contacts.clickSave();
	}

	@Then("new contact should be created")
	public void new_contact_should_be_created() {
		String ExpectedTitle2 = "Contact: geeta ~ Salesforce - Developer Edition";
		String ActualTitle2 = driver.getTitle();
		Assert.assertEquals(ActualTitle2, ExpectedTitle2);
	}

	@When("i click on the create new view button")
	public void i_click_on_the_create_new_view_button() {
		loginstepdef.contacts.clickCreateViewButton();
	}

	@When("i enter the view name")
	public void i_enter_the_view_name() {
	    loginstepdef.contacts.enterViewName("ABCD");
	}

	@When("i enter the view unique name")
	public void i_enter_the_view_unique_name() {
		Random random = new Random();
		String name = "EFGH" + random.nextInt(12345) + 10000;
		loginstepdef.contacts.enterViewName(name);
	}

	@When("i click on save button on the view new page")
	public void i_click_on_save_button_on_the_view_new_page() {
	    loginstepdef.contacts.save();
	}

	@Then("i should see the created new view name in contacts")
	public void i_should_see_the_created_new_view_name_in_contacts() {
		String ExpectedTitle1 = "Contacts ~ Salesforce - Developer Edition";
		String ActualTitle1 = driver.getTitle();
		Assert.assertEquals(ActualTitle1, ExpectedTitle1);
	}

	@When("i click the recently created from the dropdown")
	public void i_click_the_recently_created_from_the_dropdown() {
	    loginstepdef.contacts.clickRecentlyViewedDropDownSelector();
	}

	@Then("i should see the recently created contacts")
	public void i_should_see_the_recently_created_contacts() {
		String ExpectedTitle1 = "Contacts ~ Salesforce - Developer Edition";
		String ActualTitle1 = driver.getTitle();
		Assert.assertEquals(ActualTitle1, ExpectedTitle1);
	}

	@When("i select my contacts from dropdown")
	public void i_select_my_contacts_from_dropdown() {
	    loginstepdef.contacts.clickContactDropdown();
	    loginstepdef.contacts.selectmyContact();
	}

	@Then("i should see the my contact view")
	public void i_should_see_the_my_contact_view() {
		String ExpectedTitle = "Contacts ~ Salesforce - Developer Edition";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	

	@When("i click on contact name")
	public void i_click_on_contact_name() {
	    loginstepdef.contacts.clickContactName();
	}

	@Then("i should see the entire information about the contact name")
	public void i_should_see_the_entire_information_about_the_contact_name() {
		String ExpectedTitle1 = "Contact: geetha ~ Salesforce - Developer Edition";
		String ActualTitle1 = driver.getTitle();
		Assert.assertEquals(ActualTitle1, ExpectedTitle1);
	}

	@When("click the create new view link")
	public void click_the_create_new_view_link() {
	    loginstepdef.contacts.clickViewNewHyperlink();
	}

	@When("i enter the view unique name as {string}")
	public void i_enter_the_view_unique_name_as(String string) {
		Random random = new Random();
		String name = "EFGH" + random.nextInt(12345) + 10000;
		loginstepdef.contacts.enteruniqName(name);
	}

	@When("i click the save button")
	public void i_click_the_save_button() {
	   loginstepdef.contacts.clickSave();
	}

	@Then("i should see the error messgae")
	public void i_should_see_the_error_messgae() {
		String ExpectedError= "Error: You must enter a value";
		String ActualError = loginstepdef.contacts.getErrorMsg();
		Assert.assertEquals(ActualError, ExpectedError);
	}

	@When("i click the create new view link")
	public void i_click_the_create_new_view_link() {
	    loginstepdef.contacts.clickCreateViewButton();
	}

	@When("i click the view name as {string}")
	public void i_click_the_view_name_as(String string) {
		Random random = new Random();
		String name = "EFGH" + random.nextInt(12345) + 10000;
		loginstepdef.contacts.enteruniqName(name);;
	}

	@When("i click cancel button")
	public void i_click_cancel_button() {
	    loginstepdef.contacts.ClickCancelButton();
	}

	@Then("should not created the view name")
	public void should_not_created_the_view_name() {
		String ExpectedTitle1 = "Contacts: Home ~ Salesforce - Developer Edition";
		String ActualTitle1= driver.getTitle();
		Assert.assertEquals(ActualTitle1, ExpectedTitle1);
	}

	@When("i clieck the Edit link")
	public void i_clieck_the_edit_link() {
	    loginstepdef.contacts.clickNewButton();
	}

	@Then("i should see the edit page")
	public void i_should_see_the_edit_page() {
		String ExpectedTitle1 = "Contact Edit: New Contact ~ Salesforce - Developer Edition";
		String ActualTitle1 = driver.getTitle();
		Assert.assertEquals(ActualTitle1, ExpectedTitle1);
	}

	@When("i click the last name as {string}")
	public void i_click_the_last_name_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("i click the account name as {string}")
	public void i_click_the_account_name_as(String accname) {
	    loginstepdef.contacts.enterAccount(accname);
	}

	@When("i click on save and continue")
	public void i_click_on_save_and_continue() {
	    loginstepdef.contacts.clickSaveNewButton();
	}

	@Then("new contact page is created")
	public void new_contact_page_is_created() {
		String ExpectedTitle2 = "Contact Edit: New Contact ~ Salesforce - Developer Edition";
		String ActualTitle2 = driver.getTitle();
		Assert.assertEquals(ActualTitle2, ExpectedTitle2);
		}

}
