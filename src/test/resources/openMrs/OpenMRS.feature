Feature:  OpenMrs

#  @Login
Background: Login functionality
    Given user in OpenMrs page provides 'Admin' and 'Admin123'
    Then user clicks Registration Desk and clicks loginBtn

  Scenario Outline: Positive Login scenario
    Given user in OpenMrs page provides valid '<userName>' and '<password>'
    Then user clicks on  Registration Desk and clicks loginBtn
    Then user validates home  page '<header>' to check positive login

    Examples:
      | userName | password | header                                                |
      | Admin    | Admin123 | Logged in as Super User (admin) at Registration Desk. |

  Scenario Outline: Negative Login scenario
    Given user in OpenMrs page provides invalid '<invalidUserName>' and '<invalidPassword>'
    Then user clicks on  Registration Desk and clicks loginBtn to successful login
    Then user validates output '<message>'

    Examples:
      | invalidUserName | invalidPassword | message                                      |
      | admin           | Admin12         | Invalid username/password. Please try again. |
      | Admi            | admin123        | Invalid username/password. Please try again. |

  Scenario Outline: User Can't login
    Given when user in openMrs page user provides '<userName>' and '<password>'
    Then user click on OpenMRS title logo user clicks cant loginBtn
    Then user validates  '<popupMessage>' and clicks OkBtn

    Examples:
      | userName | password | popupMessage                              |
      | Admin    | Admin123 | Please contact your System Administrator. |


#  @HomePageValidate
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



#@TC01

  Scenario Outline: register patient and validate that patient has been registered
    Given user has to feel in '<given>' and '<familyName>'
    And user has to choose gender
    Then user indicates the '<day>' and '<year>'
    And user has to give an '<address>' , '<city>' , '<state>' , '<country>' , '<postalCode>'
      | address    | 800 Bayside |
      | city       | Palatine    |
      | state      | IL          |
      | country    | USA         |
      | postalCode | 60074       |
    Then user indicates the '<phoneNumber>'
      | phoneNumber | 7739348346 |
    And user choose type of relate person and gives name of '<relativeName>'
      | relativeName | Nikita Krylov |
    Then user click on confirm and click on submit button

    Examples:
      | given   | familyName | day | year | address    |city       |state      |country    |postalCode |phoneNumber |relativeName |
      | Nikolay | Nikolay    | 27  | 1997 |800 Bayside |Palatine    |IL          |USA         |60074       | 7739348346 |Nikita Krylov |







  Scenario Outline: find patient
    Given user on main page clicks on find patient button
    Then user enters '<given>' and '<familyName>' and clicks enter
    And user validates that  '<given>' and '<familyName>' are equal to given and familyName
    Then user clicks on delete patient button and types reason and click confirm

    Examples:
      | given    | familyName |
      | Azamat   | Kaldarbaev |
      | codefish | codefish   |
      | Codefish | Codefish18 |
      | a        | c          |
      | a        | g          |
      | az       | az         |
      | Nikolay  | Nikolay    |














