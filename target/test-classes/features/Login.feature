Feature: salesforce login testcases

Background:

      Given the salesforce url 
			
@regression 
Scenario: Login error message - 1
When user on "LoginPage"
When i enter the username as
When i enter the password as ""
When i click on the login button
Then i should see the login error message

@regression
Scenario:  Login To SalesForce -2
When user on "LoginPage"
When i enter the username as "priya@tekarch.com"
When i enter the password as "salesforce1"
When i click on the login button
When user on "HomePage"
Then i should see the homepage

@regression
Scenario: Check RemeberMe - 3
When user on "LoginPage"
When i enter the username as "priya@tekarch.com"
When i enter the password as "salesforce1"
And i select the remember username text box
And i click on the login button
When user on "HomePage"
Then i should see the homepage
And i click on the usermenudropdown
And i select logout button
Then i should see the username on the username textbox field

@regression
Scenario: Forgot Password- 4 A
When user on "LoginPage"
When i click on the forgot password button
Then i should see the forgot password page
When i enter the username on forgot password page as "priya@tekarch.com"
And i click on the continue button
Then i should see password reset page with email associated with the username

@regression
Scenario: Forgot Password- 4 B
When user on "LoginPage"
When i enter the wrong username as "123"
When i enter wrong password as "22131"
And i click on the login button
Then i should see the error message