Feature: Login and Generate Access Token
Scenario: User logged in successfully 
Given Provide Email Id and Password
When User calls "GetTokenAPI" API with post request
Then API call got success with status code 200 
