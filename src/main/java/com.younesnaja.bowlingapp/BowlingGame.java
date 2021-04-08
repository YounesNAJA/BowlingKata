package com.younesnaja.bowlingapp;

import java.util.ArrayList;
import java.util.List;

public abstract class BowlingGame {
    protected final int NUMBER_OF_FRAMES;
    protected final int NUMBER_OF_TURNS;
    protected int turnNumber;
    protected final boolean isDone = false;
    protected List<BowlingFrame> bowlingFrames;

    public BowlingGame(int NUMBER_OF_FRAMES, int NUMBER_OF_TURNS) {
        this.NUMBER_OF_FRAMES = NUMBER_OF_FRAMES;
        this.NUMBER_OF_TURNS = NUMBER_OF_TURNS;
    }

    public abstract int getBonusRolls();

    public abstract int score();

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

     public abstract void roll(int frameNumber, int rollNumber, String knockScore);

/*    public void rollLastSpares(String... knockScore) {
        for(int i = 0; i < bowlingFrames.get(NUMBER_OF_FRAMES - 1).getLeftRolls(); i++) {
            BowlingFrame bowlingFrame = new OpenBowlingFrame();
            bowlingFrame.roll(0, knockScore[0]);
            //bowlingGame.getBowlingFrames().add(bowlingFrame);
            bowlingFrames.get(NUMBER_OF_FRAMES - 1).getSpareRolls()[i] = bowlingFrame;
        }
    }*/
}
