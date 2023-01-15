@Galen-Desktop
Feature: Galen-Desktop

  Scenario Outline: Verify Design Layout for - "<SpecFileName>"
    Given I navigate to the landing page "<URL>"
    Then I verify the layout for "<SpecFileName>" with tags "<TAGS>"

    Examples:
      | SpecFileName      | TAGS    | URL                                |
      | welcomePage.spec  | desktop | http://testapp.galenframework.com/ |
      | welcomePage1.spec | desktop | http://testapp.galenframework.com/ |
      | welcomePage2.spec | desktop | http://testapp.galenframework.com/ |
      | welcomePage3.spec | desktop | http://testapp.galenframework.com/ |
      | welcomePage4.spec | desktop | http://testapp.galenframework.com/ |
      | welcomePage5.spec | desktop | http://testapp.galenframework.com/ |
      | welcomePage6.spec | desktop | http://testapp.galenframework.com/ |