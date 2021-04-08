package com.younesnaja.bowlingapp;

import com.younesnaja.bowlingapp.impl.AbstractBowlingFrame;

import java.util.List;
import java.util.Optional;

public interface BowlingFrame {

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

    void addSpareFrame(BowlingFrame bowlingFrame);

    //boolean isDone();

    AbstractBowlingFrame.FrameTypes getFrameType();

    int scoreSymbolsToInt(char scoreSymbol);

    void addSpareRolls(List<BowlingFrame> bowlingFrames);
}
