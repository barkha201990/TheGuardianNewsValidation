Feature: Validate news article from The Guardian

  Scenario: Validate the first news article from The Guardian
    Given User open theguardian news page
    When User retrieve the first news article
    And User search for similar news articles on the web
    Then the first article should be considered valid if two or more similar articles are found