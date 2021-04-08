package com.younesnaja.bowlingapp.impl;

import com.younesnaja.bowlingapp.BowlingFrame;

public class SpareBowlingFrame extends OpenBowlingFrame {

    public SpareBowlingFrame() {
        isDone = false;
        leftRolls = 1;
        spareRolls = new BowlingFrame[leftRolls];
    }

    @Override
    public void scoreFrame() {
        frameScore = Integer.sum(Integer.sum(scoreSymbolsToInt(firstRoll), scoreSymbolsToInt(secondRoll)), scoreSymbolsToInt(spareRolls[0].getFirstRoll()));
    }
}
