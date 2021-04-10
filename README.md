# Bowling Game by #YounesNAJA
Hello!

This is a kata that I tried to develop with my favorite approach, which is the **BDD**.
In this little game, I tried to implement some of the known good practices and design patterns.
I will keep refactoring this thing. :D

Regards,
**Younes**

# BDD Tests
## Cucumber Tests Report

There is a little HTML file **BowlingGameTestReport.html** with a lot of cool stuff and colors where you can see the tests results from the last run.



## Test Examples

Here are the test examples I worked on.
The examples are based on the kata problem description instructions.

### Example: Random rolls
|  1st Roll | 2nd Roll | Turn number | Spare Rolls |  Game Score
|------------|------------|------------|------------|----------------|
| 7 | / | 0 | 1 | `10` |  
| X | * | 1 | 2 | `30` |  
| 4 | / | 2 | 1 | `50` |  
| 7 | 1 | 3 | 0 | `65` |  
| - | 8 | 4 | 0 | `73` |  
| 7 | 2 | 5 | 0 | `82` |  
| 4 | 3 | 6 | 0 | `89` |  
| 9 | - | 7 | 0 | `98` |  
| 3 | / | 8 | 1 | `108` |  
| X | * | 9 | 2 | `128` |  
| X | 3 | 10 | 2 | `141` |


### Example: All rolls are strikes
|  1st Roll | 2nd Roll | Turn number | Spare Rolls |  Game Score
|------------|------------|------------|------------|----------------|
| X | * | 0 | 2 | `10` |  
| X | * | 1 | 2 | `30` |  
| X | * | 2 | 2 | `60` |  
| X | * | 3 | 2 | `90` |  
| X | * | 4 | 2 | `120` |  
| X | * | 5 | 2 | `150` |  
| X | * | 6 | 2 | `180` |  
| X | * | 7 | 2 | `210` |  
| X | * | 8 | 2 | `240` |  
| X | * | 9 | 2 | `270` |  
| X | X | 10 | 2 | `300` |

### Example: All rolls are spares
|  1st Roll | 2nd Roll | Turn number | Spare Rolls |  Game Score
|------------|------------|------------|------------|----------------|
| 5 | / | 0 | 1 | `10` |  
| 5 | / | 1 | 1 | `25` |  
| 5 | / | 2 | 1 | `40` |  
| 5 | / | 3 | 1 | `55` |  
| 5 | / | 4 | 1 | `70` |  
| 5 | / | 5 | 1 | `85` |  
| 5 | / | 6 | 1 | `100` |  
| 5 | / | 7 | 1 | `115` |  
| 5 | / | 8 | 1 | `130` |  
| 5 | / | 9 | 1 | `145` |  
| 5 | * | 10 | 1|  `150` |

