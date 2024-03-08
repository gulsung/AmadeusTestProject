Feature: Flight search functionality

  Scenario: Users cannot enter the same departure and destination locations
    Given the user is on the flight search page
    When the user enters the same departure and destination locations
    Then an error should be displayed

  Scenario: The number of flights found matches the displayed count
    Given the user is on the flight search page
    When the user searches for flights from Istanbul to Los Angeles
    Then the listed flights count should match the found items count
