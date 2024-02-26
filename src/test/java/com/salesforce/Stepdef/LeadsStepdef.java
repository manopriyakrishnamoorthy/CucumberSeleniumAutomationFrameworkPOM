package com.salesforce.Stepdef;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.salesforce.pages.home.HomePage;
import com.salesforce.pages.leads.LeadsPage;
import com.salesforce.pages.login.LoginPage;
import com.salesforce.utilities.Log4JUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadsStepdef {
	
	private LoginStepdef loginstepdef;
	WebDriver driver;
	 // PicoContainer injects class ContextSteps
	public LeadsStepdef(LoginStepdef loginstepdef) {
		this.loginstepdef = loginstepdef;
		driver = loginstepdef.getDriver();
	}
	
	
	@When("click the leads tab link")
	public void click_the_leads_tab_link() throws InterruptedException {
	    loginstepdef.home.clickLeadstab();
	    Thread.sleep(3000);
	}

	@Then("i should see the leads home page")
	public void i_should_see_the_leads_home_page() {
		String ExpectedTitle = "Leads: Home ~ Salesforce - Developer Edition";
		String ActualTitle = loginstepdef.home.getPageTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	@When("click the leads drop down list")
	public void click_the_leads_drop_down_list() {
	    loginstepdef.leads.dropdownLeads();
	}

	@Then("i should see the list of drop down")
	public void i_should_see_the_list_of_drop_down() {
	    loginstepdef.leads.getLeadsdropDownText();
	}

	@When("click on the todays leads from dropdown")
	public void click_on_the_todays_leads_from_dropdown() {
	    loginstepdef.leads.selectOption();
	}

	@When("i click go button")
	public void i_click_go_button() {
	    loginstepdef.leads.clickGo();
	}

	@Then("i should see which ever i selected already")
	public void i_should_see_which_ever_i_selected_already() {
		String ExpectedTitle = "Leads ~ Salesforce - Developer Edition";
		String ActualTitle = loginstepdef.home.getPageTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

	@When("i click new button")
	public void i_click_new_button() {
	    loginstepdef.leads.clickNew();
	}

	@Then("i should see leads new page")
	public void i_should_see_leads_new_page() {
		String ExpectedTitle = "Lead Edit: New Lead ~ Salesforce - Developer Edition";
		String ActualTitle = loginstepdef.leads.getPageTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

	@When("i enter the last name as {string}")
	public void i_enter_the_last_name_as(String lastname) {
	    loginstepdef.leads.enterLastName(lastname);
	}

	@When("i enter the compqny name as {string}")
	public void i_enter_the_compqny_name_as(String company) {
	    loginstepdef.leads.enterCompany(company);
	}

	@When("i click save button")
	public void i_click_save_button() {
	   loginstepdef.leads.clickSave();
	}

	@Then("i should see the newly created leads page")
	public void i_should_see_the_newly_created_leads_page() {
		String ExpectedTitle1 = "Lead: ABCD ~ Salesforce - Developer Edition";
		String ActualTitle1 = loginstepdef.leads.getPageTitle();
		Assert.assertEquals(ExpectedTitle1, ActualTitle1);
	}


}
