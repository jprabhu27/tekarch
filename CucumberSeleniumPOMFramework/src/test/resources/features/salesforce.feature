Feature: Login into Salesforce application

Scenario: #2 Login to Salesforce
Given user opens salesforce application
When user on "LoginPage"
Then expecting page title to be "Login | Salesforce"
When user enters username
When user enters password
When user clicks Login button
When user on "HomePage"
Then expecting page title to be "Home Page ~ Salesforce - Developer Edition"

Scenario: #5 Select user menu
Given user launches and logs into salesforce 
When user on "HomePage"
Then expecting page title to be "Home Page ~ Salesforce - Developer Edition"
When user clicks username dropdown
Then username dropdown contains "My Profile" "My Settings" "Developer Console" "Switch to Lightning Experience" "Logout"

