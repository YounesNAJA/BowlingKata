package com.younesnaja.bowlingapp.game;

import com.younesnaja.bowlingapp.exception.InvalidKnockedPinsNumber;
import com.younesnaja.bowlingapp.exception.MaxKnockedPinsExceededException;
import com.younesnaja.bowlingapp.exception.NumberOfRollsNotAllowedException;
import com.younesnaja.bowlingapp.frame.BowlingFrame;

import java.util.List;

public abstract class BowlingGame implements GameObservable {
    protected final int NUMBER_OF_FRAMES;
    protected int turnNumber;
    protected List<BowlingFrame> bowlingFrames;

    public BowlingGame(int NUMBER_OF_FRAMES) {
        this.NUMBER_OF_FRAMES = NUMBER_OF_FRAMES;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    protected void initFrames() {}

    public abstract int scoreGame();

    public int getNumberOfFrames() {
        return NUMBER_OF_FRAMES;
    }

    public List<BowlingFrame> getBowlingFrames() {
        return bowlingFrames;
    }

    @Override
    public String toString() {
        return "BowlingGame{" +
                "bowlingFrames=" + bowlingFrames +
                '}';
    }

    public abstract void roll(int frameNumber, int rollNumber, String knockScoreString) throws NumberOfRollsNotAllowedException, MaxKnockedPinsExceededException, InvalidKnockedPinsNumber;

    public abstract boolean isRollValid(String knockScoreString);
}
