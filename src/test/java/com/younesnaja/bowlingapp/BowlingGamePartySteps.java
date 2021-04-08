package com.younesnaja.bowlingapp;

import com.younesnaja.bowlingapp.impl.TenPinBowlingGame;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BowlingGamePartySteps {
    private BowlingGame bowlingGame;

    @Given("A bowling game of 10 turns")
    public void aBowlingGameOfTurns() {
        bowlingGame = new TenPinBowlingGame();
        Assert.assertEquals(10, bowlingGame.getNumberOfFrames());
    }

    @When("Turn number is {int} and the bowling player scored {word} and {word}")
    public void turnNumberIsTurnNumberAndTheBowlingPlayerScoredFirstRollAndSecondRoll(int turnNumber, String firstRoll, String secondRoll) {
        bowlingGame.roll(turnNumber, 0, firstRoll);
        Assert.assertEquals(firstRoll.charAt(0),
                (turnNumber <= 9) ?
                        bowlingGame.bowlingFrames.get(turnNumber).getFirstRoll() :
                        bowlingGame.bowlingFrames.get(bowlingGame.getNumberOfFrames() - 1).getFirstRoll());

        bowlingGame.roll(turnNumber, 1, secondRoll);
        Assert.assertEquals(secondRoll.charAt(0),
                (turnNumber <= 9) ?
                        bowlingGame.bowlingFrames.get(turnNumber).getSecondRoll() :
                        bowlingGame.bowlingFrames.get(bowlingGame.getNumberOfFrames() - 1).getSecondRoll());
    }

    @And("partial score should be equal to {int}")
    public void partialScoreShouldBeEqualToPartialScore(int partialScore) {
        Assert.assertEquals(partialScore, bowlingGame.score());
    }

    @Then("Spare rolls for the {int} should be {int}")
    public void spareRollsForTheTurnNumberShouldBeSpareRolls(int turnNumber, int spareRolls) {
        Assert.assertEquals(spareRolls, bowlingGame.getBowlingFrames().get(turnNumber).getSpareRolls().length);
    }
}
