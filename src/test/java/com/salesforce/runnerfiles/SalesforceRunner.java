package com.salesforce.runnerfiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		//features = {"src/test/resources/features/Login.feature","src/test/resources/features/Leads.feature",""src/test/resources/features/Contacts.feature""} ,
		features = {"src/test/resources/features/Contacts.feature"} ,
		
		glue = {"com.salesforce.Stepdef"},
		monochrome = true,
		dryRun = false,
		//tags = "@regression",
		plugin = {"pretty","html:target/cucumber-reports.html"}
				
)

public class SalesforceRunner extends AbstractTestNGCucumberTests {

}
