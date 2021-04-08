package com.younesnaja.bowlingapp.impl;

import com.younesnaja.bowlingapp.BowlingFrame;

public abstract class AbstractBowlingFrame implements BowlingFrame {
    public enum FrameTypes {
        OPEN, SPARE, STRIKE
    }

    protected char firstRoll;
    protected char secondRoll;
    protected int leftRolls = 0;
    protected int frameNumber;
    protected FrameTypes frameType;
    protected char[] spareRolls;
    protected int frameScore = 0;
    protected boolean isDone = false;

    public char getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(char firstRoll) {
        this.firstRoll = firstRoll;
    }

    public char getSecondRoll() {
        return secondRoll;
    }

    @Override
    public void setLeftRolls(int leftRolls) {
        this.leftRolls = leftRolls;
    }

    @Override
    public FrameTypes getFrameType() {
        return frameType;
    }

    public void setFrameType(FrameTypes frameType) {
        this.frameType = frameType;
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
        if(frameScore == 0)
            scoreFrame();
        return frameScore;
    }

    @Override
    public abstract void addSpareFrame(BowlingFrame bowlingFrame);

    public int scoreSymbolsToInt(char scoreSymbol) {
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

    @Override
    public AbstractBowlingFrame clone() throws CloneNotSupportedException {
        return (AbstractBowlingFrame) super.clone();
    }
}
