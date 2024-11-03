Feature: Navigate to the Page and verify quota limits are displayed

  Background:
    Given the user navigates to the "https://documentation.history.mot.api.gov.uk/"

  @smoke
  Scenario: 01- Verify the quota limits are displayed in the documentation.
    When user click on the link "rate limits"
    And verify user is on "Rate limits" page
    Then verify limit type "Quota" is display with the limit "500000"
    And user navigate back to homepage

  @smoke
  Scenario: 04 - Verify Error code is present with reason
    When user click on the link "error codes"
    And verify user is on "Error Codes" page
    Then verify error code is display with the error description
      | error_code | error_Description                                                    |
      | MOTH-NP-01 | DVLA ID is required but has not been provided in the request         |
      | MOTH-FB-02 | The access token sent with the request has expired                   |
      | MOTH-NP-03 | MOT test number is required but has not been provided in the request |
    And user navigate back to homepage

