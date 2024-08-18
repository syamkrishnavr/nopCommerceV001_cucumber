Feature: Login
  Scenario: Navigating to Admin page
    Given User Launch Chrome browser
    When User Opens URL "https://www.opencart.com/"
    Then Page title should be "OpenCart - Open Source Shopping Cart Solution"
    When User Click on Link "Demo"
    Then Text Should Be Available On The Page "OpenCart Demonstration"
    When User Click on Link "View Administration"
    Then User should be in New Tab "Administration"
#    And User Enters Email as "admin@yourstore.com" and Password as "admin"
#    And Click on Log in
#    Then Page title should be "Dashboard/nopCommerce administration"
#    When User click on logout link
#    Then Page title should be "Your store. Login"
#    And Close the Browser