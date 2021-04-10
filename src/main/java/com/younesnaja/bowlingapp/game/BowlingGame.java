package com.younesnaja.bowlingapp.game;

import com.younesnaja.bowlingapp.exception.NumberOfRollsNotAllowedException;
import com.younesnaja.bowlingapp.frame.BowlingFrame;

import java.util.List;

public abstract class BowlingGame implements GameObservable {
    protected final int NUMBER_OF_FRAMES;
    protected final int NUMBER_OF_TURNS;
    protected int turnNumber;
    protected final boolean isDone = false;
    protected List<BowlingFrame> bowlingFrames;

    public BowlingGame(int NUMBER_OF_FRAMES, int NUMBER_OF_TURNS) {
        this.NUMBER_OF_FRAMES = NUMBER_OF_FRAMES;
        this.NUMBER_OF_TURNS = NUMBER_OF_TURNS;
    }

    protected BowlingGame() {
        NUMBER_OF_FRAMES = 10;
        NUMBER_OF_TURNS = 2;
    }

    protected void initFrames() {}

    public abstract int getBonusRolls();

    public abstract int scoreGame();

    public abstract boolean isDone();

    public abstract void setFrames(List bowlingFrames);

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

    public abstract void roll(int frameNumber, int rollNumber, char knockScore) throws NumberOfRollsNotAllowedException;

    public abstract boolean isRollValid(char knockScore);
}
