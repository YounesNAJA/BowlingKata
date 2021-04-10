package com.younesnaja.bowlingapp.frame;

import com.younesnaja.bowlingapp.frame.impl.AbstractBowlingFrame;

public interface BowlingFrame extends FrameObserver {

    char getFirstRoll();

    void setFirstRoll(char firstRoll);

    void setSecondRoll(char secondRoll);

    char getSecondRoll();

    void scoreFrame();

    int getScore();

    int getLeftRolls();

    void setFrameType(AbstractBowlingFrame.FrameTypes frameType);

    void setLeftRolls(int leftRolls);

    char[] getSpareRolls();

    AbstractBowlingFrame.FrameTypes getFrameType();

    int scoreSymbolsToInt(char scoreSymbol);
}
