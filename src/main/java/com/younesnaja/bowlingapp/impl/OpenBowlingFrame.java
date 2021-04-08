package com.younesnaja.bowlingapp.impl;

import com.younesnaja.bowlingapp.BowlingFrame;

public class OpenBowlingFrame extends AbstractBowlingFrame {
    protected int leftRolls = 0;

    public OpenBowlingFrame(char knockScore) {
        firstRoll = knockScore;
    }

    @Override
    public void roll(int rollNumber, String knockScore) {
        if(rollNumber == 0) {
            firstRoll = knockScore.charAt(0);
        } else if (rollNumber == 1){
            secondRoll = knockScore.charAt(0);
            if(leftRolls == 0)
                setIsDone(true);
        } else {
            if(spareRolls.length > rollNumber) {
                spareRolls[rollNumber] = new OpenBowlingFrame(knockScore.charAt(0));
            }
        }

        if(leftRolls == 0)
            setIsDone(true);
    }

    public OpenBowlingFrame() {
    }

    @Override
    public void scoreFrame() {
        frameScore = Integer.sum(scoreSymbolsToInt(firstRoll), scoreSymbolsToInt(secondRoll));
    }

    @Override
    public void addSpareFrame(BowlingFrame... bowlingFrame) {
        if(isDone) {
            if(bowlingFrame.length > 0) {
                for (int i = 0; i < bowlingFrame.length; i++) {
                    spareRolls[i] = bowlingFrame[i];
                }
            }
        }
    }

    @Override
    public boolean isDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public int getLeftRolls() {
        return leftRolls;
    }
}
