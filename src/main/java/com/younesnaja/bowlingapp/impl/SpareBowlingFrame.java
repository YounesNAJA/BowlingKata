package com.younesnaja.bowlingapp.impl;

import com.younesnaja.bowlingapp.BowlingFrame;

import java.util.List;

public class SpareBowlingFrame extends AbstractBowlingFrame {

    public SpareBowlingFrame(int frameNumber) {
        this.frameNumber = frameNumber;
        isDone = false;
        leftRolls = 1;
        spareRolls = new char[leftRolls];
    }

    @Override
    public void setSecondRoll(char secondRoll) {
        this.secondRoll = secondRoll;
    }

    @Override
    public void scoreFrame() {
        //frameScore = Integer.sum(Integer.sum(scoreSymbolsToInt(firstRoll), scoreSymbolsToInt(secondRoll)), scoreSymbolsToInt(spareRolls[0].getFirstRoll()));

        if(spareRolls.length == 1) {
            frameScore = Integer.sum(Integer.sum(scoreSymbolsToInt(firstRoll), scoreSymbolsToInt(secondRoll)), scoreSymbolsToInt(getSpareRolls()[0]));
        } else if(spareRolls.length == 2) {
            frameScore = Integer.sum(Integer.sum(scoreSymbolsToInt(firstRoll), scoreSymbolsToInt(getSpareRolls()[0])), scoreSymbolsToInt(getSpareRolls()[1]));
        } else {
            frameScore = Integer.sum(scoreSymbolsToInt(firstRoll), scoreSymbolsToInt(secondRoll));
        }
    }

    @Override
    public void addSpareFrame(BowlingFrame bowlingFrame) {
        spareRolls[0] = bowlingFrame.getFirstRoll();
        spareRolls[1] = bowlingFrame.getSecondRoll();
    }

    @Override
    public int getLeftRolls() {
        return leftRolls;
    }

    @Override
    public void addSpareRolls(List<BowlingFrame> bowlingFrames) {
        if(frameNumber < 9) {
            if(frameType.equals(FrameTypes.STRIKE)) {
                spareRolls[0] = bowlingFrames.get(frameNumber + 1).getFirstRoll();

                if(bowlingFrames.get(frameNumber + 1).getFirstRoll() != 'X') {
                    if(spareRolls.length == 2)
                            spareRolls[1] = bowlingFrames.get(frameNumber + 1).getSecondRoll();
                } else {
                    if(spareRolls.length == 2)
                        spareRolls[1] = (frameNumber == 8)? bowlingFrames.get(frameNumber + 1).getSpareRolls()[0] : bowlingFrames.get(frameNumber + 2).getFirstRoll();
                }
            } else if(frameType.equals(FrameTypes.SPARE)) {
                spareRolls[0] = bowlingFrames.get(frameNumber + 1).getFirstRoll();
            }
        }
    }

    @Override
    public SpareBowlingFrame clone() throws CloneNotSupportedException {
        return (SpareBowlingFrame) super.clone();
    }
}
