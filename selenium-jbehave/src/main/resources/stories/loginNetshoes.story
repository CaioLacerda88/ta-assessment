Narrative:
As an user
I want to login to my application
So that I access my user features

Scenario: User must be able to login
Given I am on the homepage specified
When I input the 'userName'
And the 'password'
And click on login
Then user should authenticate and see the home page
Examples:
|userName       			  |password        |
|caiolacerda88@gmail.com      |netcaio333.     |

Scenario: Invalid user must not be able to login
Given I am on the homepage specified
When I input the 'userName'
And the 'password'
And click on login
Then I should see an invalid login message
Examples:
|userName       			  |password        |
|caiolacerda88@gmail.com      |wrongPassword   |