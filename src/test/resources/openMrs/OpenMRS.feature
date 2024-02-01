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




  @smoke
  Scenario Outline: positive scenario for creating an active visits
    Given user is on main page and clicks on find patient record, chooses a patient and clicks on it
    Then user clicks on start visit button and then on confirm button
    And user clicks on main page, clicks active visits, chooses the patient, then clicks visits noe
    Then under add presumed user '<provides>' nvi and clicks on nonCodeNviOption
    And user clicks confirmed and save button
    And user clicks conditions, add new conditions and provides '<condition>' headache
    Then user clicks on headache given option and clicks on save button
    Then user clicks on main page button, clicks active visits, clicks on patient
    And user clicks end visit and clicks yes button
Examples:
    |provides|condition|
    |nvi     |headache |









