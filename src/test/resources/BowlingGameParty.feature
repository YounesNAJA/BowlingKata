Feature: Bowling Game Party

  As a bowler, I want to play a bowling party and know my score for each turn.

  Scenario Outline: A random scores bowling game
    Given A bowling game of 10 turns
    When  Turn number is <turnNumber> and the bowling player scored <firstRoll> and <secondRoll>
    Then  Spare rolls for the <turnNumber> should be <spareRolls>
    And   partial score should be equal to <partialScore>

    Examples:
      | firstRoll | secondRoll | turnNumber | spareRolls | partialScore |
      | 7         | 3          | 0          | 1          | 10           |
      | X         | 0          | 1          | 2          | 30           |
      | 4         | 6          | 2          | 1          | 40           |
      | 7         | 1          | 3          | 0          | 55           |
      | -         | 8          | 4          | 0          | 63           |
      | 7         | 2          | 5          | 0          | 72           |
      | 4         | 3          | 6          | 0          | 79           |
      | 9         | 0          | 7          | 0          | 88           |
      | 3         | 7          | 8          | 1          | 98           |
      | X         | 0          | 9          | 2          | 118          |
      | X         | 0          | 10         | 0          | 128          |
      | 3         | 0          | 11         | 0          | 131          |
