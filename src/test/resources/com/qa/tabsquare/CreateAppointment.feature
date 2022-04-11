Feature: DrBatra Appointment

  Scenario: Verify user can reach to Confirm appointment page
    Given I am on the "drbatra"'s home page
    When I Hoverover "TREATMENTS" menu
    And I click on "Immunity" option under "Child Health" submenu
    Then I am on the "Immunity" page
		And I click on the chatbot
		And I close chatbot
		And I click on the "CONSULT NOW" field
		Then I am on the "book-an-appointment" page
		And I enter below details
		| Name | MobileNumber | Email          | TC   |
		| Test | 9090909090  | test@gmail.com | true |
		And I click on the "NEXT" field
		And I can see "CONFIRM YOUR APPOINTMENT" button