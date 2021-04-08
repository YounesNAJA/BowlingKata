package com.younesnaja.bowlingapp.impl;

import com.younesnaja.bowlingapp.BowlingFrame;

public abstract class AbstractBowlingFrame implements BowlingFrame {
    protected char firstRoll;
    protected char secondRoll;
    protected BowlingFrame[] spareRolls;
    protected int frameScore = 0;
    protected boolean isDone = false;

    public char getFirstRoll() {
        return firstRoll;
    }

    public char getSecondRoll() {
        return secondRoll;
    }

    @Override
    public BowlingFrame[] getSpareRolls() {
        if(spareRolls == null)
            spareRolls = new BowlingFrame[0];

        return spareRolls;
    }

    @Override
    public abstract void roll(int rollNumber, String knockScore);

    @Override
    public abstract void scoreFrame();

    @Override
    public int getScore() {
        if(frameScore == 0)
            scoreFrame();
        return frameScore;
    }

    @Override
    public abstract void addSpareFrame(BowlingFrame... bowlingFrame);

    protected int scoreSymbolsToInt(char scoreSymbol) {
        if(Character.isLetter(scoreSymbol) && scoreSymbol == 'X'){
            return 10;
        }

        if(Character.isLetter(scoreSymbol) && scoreSymbol == '/'){
            return 10 - scoreSymbolsToInt(firstRoll);
        }

        if(Character.isDigit(scoreSymbol)){
            return Integer.parseInt(String.valueOf(scoreSymbol));
        }

        return 0;
    }

    @Override
    public String toString() {
        return "AbstractBowlingFrame{" +
                "firstRoll=" + firstRoll +
                ", secondRoll=" + secondRoll +
                ", frameScore=" + frameScore +
                '}';
    }
}
