Feature: Navigate to the Page and verify quota limits are displayed

  Background:
    Given the user navigates to the "https://documentation.history.mot.api.gov.uk/"

  @smoke
  Scenario: 01- Verify the quota limits are displayed in the documentation.
    When user click on the link "rate limits"
    And verify user is on "Rate limits" page
    Then verify limit type "Quota" is display with the limit "500000"
    And user navigate back to homepage

  Scenario Outline: 04 - Verify Error code is present with reason
    When user click on the link "error codes"
    And verify user is on "Error Codes" page
    Then verify error code "<error_code>" is display with the description "<error_message>"
    And user navigate back to homepage

    Examples:
      | error_code | error_message                                                |
      | MOTH-NP-01 | DVLA ID is required but has not been provided in the request |
