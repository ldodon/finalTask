Feature: Final Project Test

@ContactPageDisplayed
Scenario: Ability to open the Contact Page
Given user goes to the 'Home Page' page
And user is on the 'Home Page' page
When user clicks to 'Contact Us' button
Then  user is on the 'Contact Us' page


@ContactCustomerService
Scenario: Ability to contact customer service
Given user goes to the 'Contact Us' page
And user is on the 'Contact Us' page
When user choose 'Subject Heading'
And user input 'Email address'
And user input 'Order reference'
And user input 'Message'
Then user clicks to 'Send' button
And confirmation message is displayed

@WomenPageDisplayed
Scenario: Ability to open the Women Page
Given user goes to the 'Home Page' page
And user is on the 'Home Page' page
When user clicks to 'Women' button
Then  user is on the 'Women Page' page



