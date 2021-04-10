package com.younesnaja.bowlingapp.steps;

import com.younesnaja.bowlingapp.config.InMemoryBowlingGameContainer;
import com.younesnaja.bowlingapp.exception.NumberOfRollsNotAllowedException;
import io.cucumber.java8.En;
import org.junit.Assert;

public class PartialBowlingGame implements En {
    public PartialBowlingGame(InMemoryBowlingGameContainer inMemoryBowlingGameContainer) {
        When("^I start my turn, I should not have more than (\\d+) rolls$", (Integer rolls) -> {

        });
        When("^I start my turn, and roll as follow, (.), (.), (.)$", (String scoreA, String scoreB, String scoreC) -> {
            inMemoryBowlingGameContainer.getBowlingGame().roll(0, 0, scoreA.charAt(0));
            Assert.assertEquals(scoreA.charAt(0), inMemoryBowlingGameContainer.getBowlingGame().getBowlingFrames().get(0).getFirstRoll());

            inMemoryBowlingGameContainer.getBowlingGame().roll(0, 1, scoreB.charAt(0));
            Assert.assertEquals(scoreB.charAt(0), inMemoryBowlingGameContainer.getBowlingGame().getBowlingFrames().get(0).getSecondRoll());

            Assert.assertThrows(NumberOfRollsNotAllowedException.class, () -> {
                inMemoryBowlingGameContainer.getBowlingGame().roll(0, 2, scoreC.charAt(0));
            });
        });

        And("^the game should not contain more than (\\d+) frames$", (Integer frames) -> {
            inMemoryBowlingGameContainer.initGame();
        });
        Then("^I should not have more than (\\d+) rolls$", (Integer arg0) -> {
        });
    }
}
