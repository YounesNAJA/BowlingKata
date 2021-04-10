Feature: Partial Bowling Game Party

  As a bowler, I want to check if the number of rolls and frames is correct

  Scenario: A random scores bowling game
    Given a bowling game of 10 turns
    When  I start my turn, and roll as follow, 7, 1, 1
    Then  I should not have more than 2 rolls
    And   the game should not contain more than 10 frames
