package com.younesnaja.bowlingapp.steps;

import com.younesnaja.bowlingapp.config.InMemoryBowlingGameContainer;
import io.cucumber.java8.En;
import org.junit.Assert;

public class CompleteBowlingGameSteps implements En {

    public CompleteBowlingGameSteps(InMemoryBowlingGameContainer inMemoryBowlingGameContainer) {
        Given("^a bowling game of ([0-9]{2}) turns$", (Integer turns) -> {
            Assert.assertEquals(turns, (Integer) inMemoryBowlingGameContainer.getBowlingGame().getNumberOfFrames());
        });

        When("^turn number is ([0-9]|10) and the bowling player scored (.) and (.)$", (Integer turnNumber, String firstRollScore, String secondRollScore) -> {
            inMemoryBowlingGameContainer.getBowlingGame().roll(turnNumber, 0, firstRollScore);
            inMemoryBowlingGameContainer.getBowlingGame().roll(turnNumber, 1, secondRollScore);

            if(turnNumber <= 9) {
                Assert.assertEquals(firstRollScore.charAt(0), inMemoryBowlingGameContainer.getBowlingGame().getBowlingFrames().get(turnNumber).getFirstRoll());
                Assert.assertEquals(secondRollScore.charAt(0), inMemoryBowlingGameContainer.getBowlingGame().getBowlingFrames().get(turnNumber).getSecondRoll());
            } else {
                Assert.assertEquals(firstRollScore.charAt(0), inMemoryBowlingGameContainer.getBowlingGame().getBowlingFrames().get(inMemoryBowlingGameContainer.getBowlingGame().getNumberOfFrames() - 1).getSpareRolls()[0]);
                if(inMemoryBowlingGameContainer.getBowlingGame().getBowlingFrames().get(inMemoryBowlingGameContainer.getBowlingGame().getNumberOfFrames() - 1).getLeftRolls() == 2)
                    Assert.assertEquals(secondRollScore.charAt(0), inMemoryBowlingGameContainer.getBowlingGame().getBowlingFrames().get(inMemoryBowlingGameContainer.getBowlingGame().getNumberOfFrames() - 1).getSpareRolls()[1]);
            }
        });

        And("^the roll (.) & (.) should be valid$", (String firstRollScore, String secondRollScore) -> {
            Assert.assertTrue(inMemoryBowlingGameContainer.getBowlingGame().isRollValid(firstRollScore));
            Assert.assertTrue(inMemoryBowlingGameContainer.getBowlingGame().isRollValid(secondRollScore));
        });

        And("^score for turn ([0-9]|10) should be equal to (\\d+)$", (Integer turnNumber, Integer partialScore) -> {
            Assert.assertEquals(partialScore, (Integer) inMemoryBowlingGameContainer.getBowlingGame().scoreGame());
            if(turnNumber == 10)
                inMemoryBowlingGameContainer.initGame();
        });

        Then("^spare rolls for the ([0-9]|10) should be (0|1|2)$", (Integer turnNumber, Integer spareRolls) -> {
            if(turnNumber <= 9) {
                Assert.assertEquals(spareRolls, (Integer) inMemoryBowlingGameContainer.getBowlingGame().getBowlingFrames().get(turnNumber).getSpareRolls().length);
            } else {
                Assert.assertEquals(spareRolls, (Integer) inMemoryBowlingGameContainer.getBowlingGame().getBowlingFrames().get(inMemoryBowlingGameContainer.getBowlingGame().getNumberOfFrames() - 1).getSpareRolls().length);
            }
        });
    }
}
