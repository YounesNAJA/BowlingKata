package com.younesnaja.bowlingapp;

import java.util.ArrayList;
import java.util.List;

public abstract class BowlingGame {
    protected final int NUMBER_OF_FRAMES;
    protected List<BowlingFrame> bowlingFrames;

    public BowlingGame(int number_of_frames) {
        NUMBER_OF_FRAMES = number_of_frames;
        bowlingFrames = new ArrayList<>(NUMBER_OF_FRAMES);
    }

    public abstract int getLeftRolls();

    public abstract int score();

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
}
