package com.younesnaja.bowlingapp;

import com.younesnaja.bowlingapp.impl.TenPinBowlingGame;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;

public class BowlingScoringSteps {
    private BowlingGame bowlingGame;

    @Given("A Bowling game of 10 turns")
    public void aBowlingGameOfTurns() {
        bowlingGame = new TenPinBowlingGame();
        Assert.assertEquals(10, bowlingGame.getNumberOfFrames());
    }

    @When("Bowler got strikes in all his ten rolls")
    public void bowlerGotStrikesInAllHisTenRolls() {
        for(int i = 0; i < bowlingGame.getNumberOfFrames(); i++) {
            bowlingGame.roll(i,0, "X");
        }

        Assert.assertEquals(10, bowlingGame.getBowlingFrames()
                .stream()
                .filter(bowlingFrame -> bowlingFrame.getFirstRoll() == 'X')
                .map(BowlingFrame::getFirstRoll).count());
    }

    @When("Bowler scores {word} points in all his ten rolls")
    public void bowlerScoresPointsInAllHisRolls(String knockScore) {
        for(int i = 0; i < bowlingGame.getNumberOfFrames(); i++) {
            bowlingGame.roll(i,0, knockScore);
        }
    }

    @And("Does more {word} in the next left rolls")
    public void doesMoreXInTheNextLeftRolls(String knockScore) {
        for(int i = bowlingGame.getNumberOfFrames(); i < bowlingGame.getNumberOfFrames() + bowlingGame.getBonusRolls(); i++) {
            bowlingGame.roll(i,0, knockScore);
        }

        Assert.assertEquals('X', bowlingGame.getBowlingFrames().get(bowlingGame.getNumberOfFrames() - 1).getSpareRolls()[0]);
        Assert.assertEquals('X', bowlingGame.getBowlingFrames().get(bowlingGame.getNumberOfFrames() - 1).getSpareRolls()[1]);

                //.filter(spareRolls -> spareRolls[0] == 'X').count());
    }

    @Then("the final score of the bowler must be {int}")
    public void theFinalScoreOfTheBowlerMustBe(int finalScore) {
        Assert.assertEquals(finalScore, bowlingGame.score());
    }

    @And("Misses every second roll")
    public void missesEverySecondRoll() {
        for(int i = 0; i < bowlingGame.getNumberOfFrames(); i++) {
            bowlingGame.roll(i,1, "-");
        }
    }

    @When("Bowler scores {string} points in all his first rolls")
    public void bowlerScoresPointsInAllHisFirstRolls(String knockScore) {
        for(int i = 0; i < bowlingGame.getNumberOfFrames(); i++) {
            bowlingGame.roll(i,1, knockScore);
        }
    }

    @And("Got spares in every second roll")
    public void gotSparesInEverySecondRoll() {
        for(int i = 0; i < bowlingGame.getNumberOfFrames(); i++) {
            bowlingGame.roll(i,1, "/");
        }
    }

    @And("Scores {string} in his last spare roll")
    public void scoresInHisLastSpareRoll(String knockScore) {
        bowlingGame.roll(10,1, knockScore);
    }


    @And("All spare rolls have been filled")
    public void allSpareRollsHaveBeenFilled() {
        //Assert.assertTrue(bowlingGame.getBowlingFrames().stream().allMatch(BowlingFrame::isDone));
    }
}
