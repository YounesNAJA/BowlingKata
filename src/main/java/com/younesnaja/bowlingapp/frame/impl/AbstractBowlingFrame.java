package com.younesnaja.bowlingapp.frame.impl;


import com.younesnaja.bowlingapp.frame.BowlingFrame;

public abstract class AbstractBowlingFrame implements BowlingFrame {
    protected char firstRoll;
    protected char secondRoll;
    protected int leftRolls = 0;
    protected int frameNumber;
    protected FrameTypes frameType;
    protected char[] spareRolls;
    protected int frameScore = 0;
    protected boolean isDone = false;

    public enum FrameTypes {
        OPEN, SPARE, STRIKE
    }

    public char getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(char firstRoll) {
        this.firstRoll = firstRoll;
    }

    public char getSecondRoll() {
        return secondRoll;
    }

    public void setFrameType(FrameTypes frameType) {
        this.frameType = frameType;
        if(FrameTypes.STRIKE.equals(frameType)){
            leftRolls = 2;
        } else if(FrameTypes.SPARE.equals(frameType)){
            leftRolls = 1;
        } else {
            leftRolls = 0;
        }

        spareRolls = new char[leftRolls];
    }

    @Override
    public char[] getSpareRolls() {
        if(spareRolls == null)
            spareRolls = new char[0];

        return spareRolls;
    }

    @Override
    public abstract void scoreFrame();

    @Override
    public int getScore() {
        return frameScore;
    }

    public int scoreSymbolsToInt(char scoreSymbol) {
        if(Character.isLetter(scoreSymbol) && scoreSymbol == 'X'){
            return 10;
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
