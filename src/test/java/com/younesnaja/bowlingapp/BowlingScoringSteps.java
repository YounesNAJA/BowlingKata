package com.younesnaja.bowlingapp;

import com.younesnaja.bowlingapp.impl.OpenBowlingFrame;
import com.younesnaja.bowlingapp.impl.SpareBowlingFrame;
import com.younesnaja.bowlingapp.impl.StrikeBowlingFrame;
import com.younesnaja.bowlingapp.impl.TenPinBowlingGame;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;

public class BowlingScoringSteps {
    private BowlingGame bowlingGame;

    @Given("A Bowling game of {int} turns")
    public void aBowlingGameOfTurns(int turns) {
        bowlingGame = new TenPinBowlingGame();
        Assert.assertEquals(10, bowlingGame.getNumberOfFrames());
    }

    @When("Bowler got strikes in all his ten rolls")
    public void bowlerGotStrikesInAllHisTenRolls() {
        for(int i = 0; i < bowlingGame.getNumberOfFrames(); i++) {
            BowlingFrame bowlingFrame = new StrikeBowlingFrame();
            bowlingFrame.roll(0, "X");
            bowlingGame.getBowlingFrames().add(bowlingFrame);
        }

        Assert.assertEquals(10, bowlingGame.getBowlingFrames()
                .stream()
                .filter(bowlingFrame -> bowlingFrame.getFirstRoll() == 'X')
                .map(BowlingFrame::getFirstRoll).count());
    }

    @When("Bowler scores {word} points in all his ten rolls")
    public void bowlerScoresPointsInAllHisRolls(String knockScore) {
        for(int i = 0; i < bowlingGame.getNumberOfFrames(); i++) {
            BowlingFrame bowlingFrame = new OpenBowlingFrame();
            bowlingFrame.roll(0, knockScore);
            bowlingGame.getBowlingFrames().add(bowlingFrame);
        }
    }

    @And("Does more {word} in the next left rolls")
    public void doesMoreXInTheNextLeftRolls(String knockScore) {
        for(int i = 0; i < bowlingGame.getLeftRolls(); i++) {
            BowlingFrame bowlingFrame = new OpenBowlingFrame();
            bowlingFrame.roll(0, knockScore);
            //bowlingGame.getBowlingFrames().add(bowlingFrame);
            bowlingGame.getBowlingFrames().get(bowlingGame.getNumberOfFrames() - 1).getSpareRolls()[i] = bowlingFrame;
        }

        Assert.assertEquals(2, Arrays.stream(bowlingGame.getBowlingFrames().get(bowlingGame.getNumberOfFrames() - 1).getSpareRolls())
                .filter(spareRolls -> spareRolls.getFirstRoll() == 'X').count());
    }

    @Then("the final score of the bowler must be {int}")
    public void theFinalScoreOfTheBowlerMustBe(int finalScore) {
        Assert.assertEquals(finalScore, bowlingGame.score());
    }

    @And("Misses every second roll")
    public void missesEverySecondRoll() {
        for(int i = 0; i < bowlingGame.getNumberOfFrames(); i++) {
            BowlingFrame bowlingFrame = new OpenBowlingFrame();
            bowlingFrame.roll(1, "-");
            bowlingGame.getBowlingFrames().add(bowlingFrame);
        }
    }

    @When("Bowler scores {string} points in all his first rolls")
    public void bowlerScoresPointsInAllHisFirstRolls(String knockScore) {
        for(int i = 0; i < bowlingGame.getNumberOfFrames(); i++) {
            BowlingFrame bowlingFrame = new OpenBowlingFrame();
            bowlingFrame.roll(0, knockScore);
            bowlingGame.getBowlingFrames().add(bowlingFrame);
        }
    }

    @And("Got spares in every second roll")
    public void gotSparesInEverySecondRoll() {
        for(int i = 0; i < bowlingGame.getNumberOfFrames(); i++) {
            BowlingFrame bowlingFrame = new SpareBowlingFrame();
            bowlingFrame.roll(1, "/");
            bowlingGame.getBowlingFrames().add(bowlingFrame);
        }
    }

    @And("Scores {string} in his last spare roll")
    public void scoresInHisLastSpareRoll(String knockScore) {
        BowlingFrame bowlingFrame = new SpareBowlingFrame();
        bowlingFrame.roll(0, knockScore);
        bowlingGame.getBowlingFrames().add(bowlingFrame);
    }


}
