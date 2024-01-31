Feature:  OpenMrs

  Scenario Outline:  OpenMrs
    Given user in OpenMrs page provides '<username>' and '<password>'
    Then user clicks Registration Desk and clciks loginBtn
    And user validates that  user in Home page by validating  '<header>'

    Examples:
      | username | Admin                                                 |
      | password | Admin123                                              |
      | header   | Logged in as Super User (admin) at Registration Desk. |

  Scenario Outline: find patient
    Given user on main page clicks on find patient button
    Then user enters '<given>' and '<familyName>' and clicks enter
    And user validates that  '<given>' and '<familyName>' are equal to given and familyName
    Then user clicks on delete patient button and types reason and click confirm

    Examples:
      | given      |  |
      | familyName |  |








