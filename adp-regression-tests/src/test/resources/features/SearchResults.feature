@JobSearchResults
Feature: Job Search Results
  As an a job seeker
  I want to search a job I interested
  In order to apply for a new position I found

  Scenario: A job seeker navigates to Search Results page and searches for a new position
    Given I am on the search results page
    When I type "QA Automation Engineer" in the 'Keyword' field
      And I select "Technology" in the 'Select a Job Category' field
      And I select "English" in the 'Language' field
    Then I click on the "Search" button
      And I should see the position "168112"
