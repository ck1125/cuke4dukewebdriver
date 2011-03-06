Feature: Sample Page loading test
  On /programmes want to see if Cucumber can be used to make a selenium testing DSL


  Scenario: A brand hub page can be loaded
    When I open '/programmes/skins'
    Then the title should be 'Skins - Channel 4'
    Then I click an item with xpath '//html/body/div/div[3]/div/div[3]/div/ul/li[2]/h3/a'
    Then browser location should be 'http://www.e4.com/skins/quizzes.html'

  Scenario: A brand hub page can be loaded and elements found on the page
    When I open '/programmes/the-it-crowd'
    Then the title should be 'The IT Crowd - Channel 4'
    Then element with id 'heroImage' should be present
    Then I click an item with xpath '//div[@id='brandInfoBox']/a[@class='watch-now-large']'
    And browser location should be 'http://www.channel4.com/programmes/the-it-crowd/4od'

  Scenario: A brand hub page can be loaded and a search done
    When I open '/programmes/the-it-crowd'
    Then the title should be 'The IT Crowd - Channel 4'
    Then element with id 'heroImage' should be present
    Then I fill form field with xpath '//*[@id="c4navSearchTxt"]' using value 'city'
    Then I submit form with name 'c4navSearch'
    Then element with id 'BrandResultContainer' should be present

