Feature:  OpenMrs


Background: Login functionality
    Given user in OpenMrs page provides 'Admin' and 'Admin123'
   Then user clicks Registration Desk and clicks loginBtn

  Scenario Outline:  OpenMrs
    And user validates that  user in Home page by validating  '<header>'

    Examples:
      | header                                                |
      | Logged in as Super User (admin) at Registration Desk. |


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










