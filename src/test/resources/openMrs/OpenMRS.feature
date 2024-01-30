Feature:  OpenMrs
  Scenario Outline:  OpenMrs
    Given user in OpenMrs page provides '<username>' and '<password>'
    Then user clicks Registration Desk and clciks loginBtn
    And user validates that  user in Home page by validating  '<headr>'

    Examples:
      | username | Admin                                                 |
      | password | Admin123                                              |
      | headr    | Logged in as Super User (admin) at Registration Desk. |






