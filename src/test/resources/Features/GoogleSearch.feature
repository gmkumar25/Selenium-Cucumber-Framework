#Author: Muthukumar Gandhi
#Keywords Summary : This feature will be testing Googlesearch scenarios

@tag
Feature: Google Search
  This feature file is about Google Search

  @tag1
  Scenario: TC01_Simple Google Search
    Given I access the Google page
    When I search for some data
    Then I should see the results
    

  @tag2
  Scenario Outline: TC02_Multiple Google Search
    Given I access the Google page
    When I search for some "<data>"
    Then I should see the results

    Examples: 
      | data  | 
      | Automation | 
      | Testing | 
