Feature: Complete Bowling Game

  As a bowler, I want to play a bowling party and know my score for each turn.

  Scenario Outline: A random scores bowling game
    Given a bowling game of 10 turns
    When  turn number is <turnNumber> and the bowling player scored <firstRoll> and <secondRoll>
    And   the roll <firstRoll> & <secondRoll> should be valid
    Then  spare rolls for the <turnNumber> should be <spareRolls>
    And   score for turn <turnNumber> should be equal to <partialScore>

    Examples: random rolls
      | firstRoll | secondRoll | turnNumber | spareRolls | partialScore |
      | 7         | /          | 0          | 1          | 10           |
      | X         | *          | 1          | 2          | 30           |
      | 4         | /          | 2          | 1          | 50           |
      | 7         | 1          | 3          | 0          | 65           |
      | -         | 8          | 4          | 0          | 73           |
      | 7         | 2          | 5          | 0          | 82           |
      | 4         | 3          | 6          | 0          | 89           |
      | 9         | -          | 7          | 0          | 98           |
      | 3         | /          | 8          | 1          | 108          |
      | X         | *          | 9          | 2          | 128          |
      | X         | 3          | 10         | 2          | 141          |

    Examples: all rolls are strikes
      | firstRoll | secondRoll | turnNumber | spareRolls | partialScore |
      | X         | *          | 0          | 2          | 10           |
      | X         | *          | 1          | 2          | 30           |
      | X         | *          | 2          | 2          | 60           |
      | X         | *          | 3          | 2          | 90           |
      | X         | *          | 4          | 2          | 120          |
      | X         | *          | 5          | 2          | 150          |
      | X         | *          | 6          | 2          | 180          |
      | X         | *          | 7          | 2          | 210          |
      | X         | *          | 8          | 2          | 240          |
      | X         | *          | 9          | 2          | 270          |
      | X         | X          | 10         | 2          | 300          |

    Examples: all rolls are spares
      | firstRoll | secondRoll | turnNumber | spareRolls | partialScore |
      | 5         | /          | 0          | 1          | 10           |
      | 5         | /          | 1          | 1          | 25           |
      | 5         | /          | 2          | 1          | 40           |
      | 5         | /          | 3          | 1          | 55           |
      | 5         | /          | 4          | 1          | 70           |
      | 5         | /          | 5          | 1          | 85           |
      | 5         | /          | 6          | 1          | 100          |
      | 5         | /          | 7          | 1          | 115          |
      | 5         | /          | 8          | 1          | 130          |
      | 5         | /          | 9          | 1          | 145          |
      | 5         | *          | 10         | 1          | 150          |
