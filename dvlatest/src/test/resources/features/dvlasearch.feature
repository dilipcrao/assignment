Feature: As a web user need to check vehicle details in dVLA site agnist the data in CSV file

  Scenario: Search the dvla website for reg numbers
    Given I am a web user
    When I navigate to dvla website
    And I provide the registration number of a vehicle from a csv file
    Then I should be able to verify the details of the vehicle as present in the csv file