Feature: salesforce leads testcases

Background:

      Given the salesforce url
			When user on "LoginPage"
			When i enter the username as "priya@tekarch.com"
			When i enter the password as "salesforce1"
			When i click on the login button
			When user on "HomePage"
			
Scenario: TC20-leadsTab
When click the leads tab link 
Then i should see the leads home page

Scenario: TC21-leadsSelectView
When click the leads tab link 
Then i should see the leads home page
When user on "LeadsPage"
When click the leads drop down list
Then i should see the list of drop down 

Scenario: TC21-leadsSelectView
When click the leads tab link 
Then i should see the leads home page
When user on "LeadsPage"
When click on the todays leads from dropdown
And i select logout button
When user on "LoginPage"
When i enter the username as "priya@tekarch.com"
When i enter the password as "salesforce1"
When i click on the login button
When user on "HomePage"
When click the leads tab link 
Then i should see the leads home page
When i click go button
Then i should see which ever i selected already

Scenario: TC23
When click the leads tab link 
Then i should see the leads home page
When user on "LeadsPage"
When click on the todays leads from dropdown
Then i should see today leads page

Scenario: TC24
When click the leads tab link 
Then i should see the leads home page
When user on "LeadsPage"
When i click new button
Then i should see leads new page
When i enter the last name as "ABCD"
When i enter the compqny name as "ABCD"
When i click save button
Then i should see the newly created leads page