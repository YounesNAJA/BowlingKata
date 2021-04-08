package com.younesnaja.bowlingapp;

import com.younesnaja.bowlingapp.impl.OpenBowlingFrame;

import java.util.List;
import java.util.Optional;

public interface BowlingFrame {

    char getFirstRoll();

    char getSecondRoll();

    void roll(int rollNumber, String knockScore);

    void scoreFrame();

    int getScore();

    int getLeftRolls();

    BowlingFrame[] getSpareRolls();

    void addSpareFrame(BowlingFrame... bowlingFrame);

    boolean isDone();

}
