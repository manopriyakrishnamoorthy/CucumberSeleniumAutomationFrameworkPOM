Feature: salesforce leads testcases

Background:

      Given the salesforce url
			When user on "LoginPage"
			When i enter the username as "priya@tekarch.com"
			When i enter the password as "salesforce1"
			When i click on the login button
			When user on "HomePage"
#Scenario: TC25
#When i click contacts tab
#When user on "ContactPage"
#Then i should see contact home page
#When i click on new button
#Then i should see new contact home page
#When i enter last name in last name field 
#When i enter the account name in account name field
#When i click on the save button in contact page
#Then new contact should be created
#
#Scenario: TC26
#When i click contacts tab
#When user on "ContactPage"
#Then i should see contact home page
#When i click on the create new view button
#When i enter the view name
#When i enter the view unique name
#When i click on save button on the view new page 
#Then i should see the created new view name in contacts
#
#Scenario: TC27
#When i click contacts tab
#When user on "ContactPage"
#Then i should see contact home page
#When i click the recently created from the dropdown
#Then i should see the recently created contacts
#
#Scenario: TC28 
#When i click contacts tab
#When user on "ContactPage"
#Then i should see contact home page
#When i select my contacts from dropdown
#Then i should see the my contact view

Scenario: TC29
When i click contacts tab
When user on "ContactPage"
Then i should see contact home page
When i click on contact name 
Then i should see the entire information about the contact name


Scenario: TC30
When i click contacts tab
When user on "ContactPage"
Then i should see contact home page
When click the create new view link
When i enter the view unique name as "EFGH"
When i click the save button
Then i should see the error messgae 


Scenario: TC31
When i click contacts tab
When user on "ContactPage"
Then i should see contact home page
When i click the create new view link
When i click the view name as "salesforce"
When i enter the view unique name as "EFGH"
When i click cancel button
Then should not created the view name

Scenario: TC31
When i click contacts tab
When user on "ContactPage"
Then i should see contact home page
When i clieck the Edit link
Then i should see the edit page
When i click the last name as "Indian"
When i click the account name as "global media"
When i click on save and continue
Then new contact page is created

