package com.younesnaja.bowlingapp.impl;

import com.younesnaja.bowlingapp.BowlingFrame;
import com.younesnaja.bowlingapp.BowlingGame;

import java.util.List;

public class TenPinBowlingGame extends BowlingGame {
    public TenPinBowlingGame() {
        super(10);
    }

    public int getLeftRolls() {
        return bowlingFrames.get(NUMBER_OF_FRAMES - 1).getLeftRolls();
    }

    public int score() {
        scoreFrames();
        return bowlingFrames.stream().mapToInt(BowlingFrame::getScore).sum();
    }

    private void scoreFrames() {
        if(bowlingFrames.stream().allMatch(BowlingFrame::isDone)){
            for (int i = 0; i < NUMBER_OF_FRAMES; i++) {
                if(bowlingFrames.get(i).getFirstRoll() == 'X') {
                    bowlingFrames.get(i).addSpareFrame(bowlingFrames.get(i).getSpareRolls()[0], bowlingFrames.get(i).getSpareRolls()[1]);
                } else if(bowlingFrames.get(i).getScore() == 10) {
                    bowlingFrames.get(i).addSpareFrame(bowlingFrames.get(i + 1));
                }

                bowlingFrames.get(i).scoreFrame();
            }
        }
    }

    public void setFrames(List bowlingFrames) {
        this.bowlingFrames = bowlingFrames;
    }
}
