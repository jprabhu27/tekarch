Feature: Login into Salesforce application

Scenario: #1 Login Error Message
Given user opens salesforce application
When user on "LoginPage"
Then expecting page title to be "Login | Salesforce"
When user enters username
Then username is displayed
When user clears password
Then password field is empty
When user clicks Login button
Then error message "Please enter your password." is displayed

Scenario: #2 Login to Salesforce
Given user opens salesforce application
When user on "LoginPage"
Then expecting page title to be "Login | Salesforce"
When user enters username
When user enters password
When user clicks Login button
When user on "HomePage"
Then expecting page title to be "Home Page ~ Salesforce - Developer Edition"

Scenario: #3 Check Remember Me
Given user opens salesforce application
When user on "LoginPage"
Then expecting page title to be "Login | Salesforce"
When user enters username
When user enters password
When user checks the remember me checkbox
When user clicks Login button
When user on "HomePage"
Then expecting page title to be "Home Page ~ Salesforce - Developer Edition"
When user clicks username dropdown
When user clicks "Logout" menu
When user on "LoginPage"
Then expecting page title to be "Login | Salesforce"
Then username is displayed

Scenario: #5 Select user menu
Given user launches and logs into salesforce 
When user on "HomePage"
Then expecting page title to be "Home Page ~ Salesforce - Developer Edition"
When user clicks username dropdown
Then username dropdown contains "My Profile" "My Settings" "Developer Console" "Switch to Lightning Experience" "Logout"

Scenario: #9 Select Logout Option 
Given user launches and logs into salesforce 
When user on "HomePage"
When user clicks username dropdown
Then username dropdown contains "My Profile" "My Settings" "Developer Console" "Switch to Lightning Experience" "Logout"
When user clicks "Logout" menu
When user on "LoginPage"
Then expecting page title to be "Login | Salesforce"