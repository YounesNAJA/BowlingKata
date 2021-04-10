package com.younesnaja.bowlingapp.frame.impl;

import com.younesnaja.bowlingapp.frame.BowlingFrame;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class SpareBowlingFrame extends AbstractBowlingFrame {

    public SpareBowlingFrame(int frameNumber) {
        this.frameNumber = frameNumber;
        isDone = false;
        leftRolls = 0;
    }

    @Override
    public void setSecondRoll(char secondRoll) {
        this.secondRoll = secondRoll;
    }

    @Override
    public void scoreFrame() {
        int firstAndSecondRollScore = Integer.sum(scoreSymbolsToInt(firstRoll), scoreSymbolsToInt(secondRoll));

        if(secondRoll == '/')
            firstAndSecondRollScore = 10;

        if(spareRolls.length == 1) {
            frameScore = Integer.sum(firstAndSecondRollScore, scoreSymbolsToInt(spareRolls[0]));
        } else if(spareRolls.length == 2) {
            int spareRollsScore = Integer.sum(scoreSymbolsToInt(spareRolls[0]), scoreSymbolsToInt(spareRolls[1]));
            if(spareRolls[1] == '/')
                spareRollsScore = 10;
            frameScore = Integer.sum(scoreSymbolsToInt(firstRoll), spareRollsScore);
        } else {
            frameScore = firstAndSecondRollScore;
        }
    }

    @Override
    public int getLeftRolls() {
        return leftRolls;
    }

    private void addSpareRolls(List<BowlingFrame> bowlingFrames) {
        if(frameNumber < 9) {
            if(frameType.equals(FrameTypes.STRIKE)) {
                spareRolls[0] = bowlingFrames.get(frameNumber + 1).getFirstRoll();

                if(bowlingFrames.get(frameNumber + 1).getFirstRoll() != 'X') {
                    if(spareRolls.length == 2) {
                        if(bowlingFrames.get(frameNumber + 1).getSecondRoll() == '/') {
                            if(scoreSymbolsToInt(bowlingFrames.get(frameNumber + 1).getFirstRoll()) > 0) {
                                spareRolls[1] = String.format("%d", 10 - Character.getNumericValue(bowlingFrames.get(frameNumber + 1).getFirstRoll())).charAt(0);
                            } else {
                                spareRolls[1] = String.format("%d", 10).charAt(0);
                            }
                        }
                    }
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
    public void update(List<BowlingFrame> bowlingFrames) {
        addSpareRolls(bowlingFrames);
        scoreFrame();
    }
}
