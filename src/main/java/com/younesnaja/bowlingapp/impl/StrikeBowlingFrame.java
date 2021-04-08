package com.younesnaja.bowlingapp.impl;

import com.younesnaja.bowlingapp.BowlingFrame;

public class StrikeBowlingFrame extends SpareBowlingFrame {

    public StrikeBowlingFrame() {
        isDone = false;
        leftRolls = 2;
        spareRolls = new BowlingFrame[leftRolls];
    }

    @Override
    public void scoreFrame() {
        if(isDone) {
            if(spareRolls.length > 0) {
                frameScore = Integer.sum(Integer.sum(scoreSymbolsToInt(firstRoll), scoreSymbolsToInt(spareRolls[0].getFirstRoll())), scoreSymbolsToInt(spareRolls[1].getFirstRoll()));
            }
            if(spareRolls.length > 1) {
                frameScore += scoreSymbolsToInt(spareRolls[1].getFirstRoll());
            }
        }
    }
}
