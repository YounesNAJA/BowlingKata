Feature: Bowling Game

  As a bowler, I want to know my score for each turn.

  Scenario: Bowler scores strikes in all his turns
    Given A Bowling game of 10 turns
    When  Bowler got strikes in all his ten rolls
    And   Does more X in the next left rolls
    Then  the final score of the bowler must be 300

  Scenario: Bowler scores 9 in each of his first rolls and misses the second roll
    Given A Bowling game of 10 turns
    When  Bowler scores "9" points in all his ten rolls
    And   Misses every second roll
    Then  the final score of the bowler must be 90

  Scenario: Bowler scores 5 in each of his first rolls and got a spare on the second roll
    Given A Bowling game of 10 turns
    When  Bowler scores "5" points in all his ten rolls
    And   Got spares in every second roll
    And   Scores "5" in his last spare roll
    Then  the final score of the bowler must be 150
