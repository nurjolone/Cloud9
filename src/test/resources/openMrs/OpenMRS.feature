Feature:  OpenMrs

Background: Login functionality
    Given user in OpenMrs page provides 'Admin' and 'Admin123'
    Then user clicks Registration Desk and clicks loginBtn

  Scenario Outline: Positive Login scenario
    Given user in OpenMrs page provides valid '<userName>' and '<password>'
    Then user clicks on  Registration Desk and clicks loginBtn
    Then user validates home  page '<header>' to check positive login

    Examples:
    |userName|password  | header                                                |
    |Admin   |Admin123  | Logged in as Super User (admin) at Registration Desk. |
  Scenario Outline: Negative Login scenario
    Given user in OpenMrs page provides invalid '<invalidUserName>' and '<invalidPassword>'
    Then user clicks on  Registration Desk and clicks loginBtn to successful login
    Then user validates output '<message>'

    Examples:
    |invalidUserName|invalidPassword|message|
    |admin          |Admin12        |Invalid username/password. Please try again.|
    |Admi           |admin123       |Invalid username/password. Please try again.|

    Scenario Outline: User Can't login
      Given when user in openMrs page user provides '<userName>' and '<password>'
      Then user click on OpenMRS title logo user clicks cant loginBtn
      Then user validates  '<popupMessage>' and clicks OkBtn

      Examples:
      |userName|password|popupMessage|
      |Admin   |Admin123|Please contact your System Administrator.|


#@smoke

  Scenario: Validate Home Page
    Then user  clicks on every desks and validate title and click on home button:
      | Find Patient Record    |
      | Active Visits          |
      | Capture Vitals         |
      | Register a patient     |
      | Appointment Scheduling |
      | Reports                |
      | Data Management        |
      | Configure Metadata     |
      | System Administration  |


    Scenario Outline: Change person info
      Given User is on home page and clicks button System Administration and clicks Advanced Administration
      Then User clicks button Manage Person
      And User enters '<name>' into line Person Name and clicks checkbox Include deleted
      And user clicks on person info line
      Then User deletes existing address in line Address and enter '<newAddress>' and clicks the button Save Patient
      And User comes back on home page by clicking link Home
      Then User is on home page and clicks button Find Person Record
      And enters patient '<findPersonName>' in the insert line and click Enter
      And User clicks dropdown Show Contact Info and validates information about address

      Examples:
      |name|newAddress|findPersonName|
      |Tina Tina|17Florida|Tina Tina |




















