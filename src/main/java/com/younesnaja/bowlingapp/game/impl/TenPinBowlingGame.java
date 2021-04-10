package com.younesnaja.bowlingapp.game.impl;

import com.younesnaja.bowlingapp.exception.NumberOfRollsNotAllowedException;
import com.younesnaja.bowlingapp.frame.BowlingFrame;
import com.younesnaja.bowlingapp.frame.impl.AbstractBowlingFrame;
import com.younesnaja.bowlingapp.frame.impl.SpareBowlingFrame;
import com.younesnaja.bowlingapp.game.BowlingGame;

import java.util.ArrayList;
import java.util.List;

public class TenPinBowlingGame extends BowlingGame {
    public TenPinBowlingGame() {
        super(10);
        initFrames();
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    @Override
    protected void initFrames() {
        bowlingFrames = new ArrayList<>(NUMBER_OF_FRAMES){{
            for (int i = 0; i < NUMBER_OF_FRAMES; i++) {
                BowlingFrame bowlingFrame = new SpareBowlingFrame(i);
                bowlingFrame.setFrameType(AbstractBowlingFrame.FrameTypes.OPEN);
                add(bowlingFrame);
            }
        }};
    }

    public int scoreGame() {
        notifyObservers();
        return bowlingFrames.stream().mapToInt(BowlingFrame::getScore).sum();
    }

    private void scoreFrames() {
        for (int i = 0; i <= turnNumber; i++) {
            bowlingFrames.get(i).update(bowlingFrames);
        }
    }

    @Override
    public void roll(int frameNumber, int rollNumber, char knockScore) throws NumberOfRollsNotAllowedException {
        if(rollNumber > 1)
            throw new NumberOfRollsNotAllowedException();

        if(frameNumber <= NUMBER_OF_FRAMES - 1) {
            setTurnNumber(frameNumber);

            BowlingFrame currentFrame = bowlingFrames.get(frameNumber);
            if(rollNumber == 0) {
                currentFrame.setFirstRoll(knockScore);
                if(knockScore == 'X') {
                    currentFrame.setFrameType(AbstractBowlingFrame.FrameTypes.STRIKE);
                    currentFrame.setSecondRoll('*');
                }
            } else if(rollNumber == 1 && knockScore != '*') {
                if(knockScore == '/'
                        || 10 == Integer.sum(Character.getNumericValue(currentFrame.getFirstRoll()), Character.getNumericValue(knockScore))) {
                    currentFrame.setSecondRoll('/');
                    currentFrame.setFrameType(AbstractBowlingFrame.FrameTypes.SPARE);
                } else {
                    currentFrame.setSecondRoll(knockScore);
                    currentFrame.setFrameType(AbstractBowlingFrame.FrameTypes.OPEN);
                }
            }

            bowlingFrames.set(turnNumber, currentFrame);
        } else {
            playBonusRoll(rollNumber, frameNumber, knockScore);
        }
        notifyObservers();
    }

    @Override
    public boolean isRollValid(char knockScore) {
        if(Character.isDigit(knockScore))
            return Character.getNumericValue(knockScore) >= 0 && Character.getNumericValue(knockScore) < 10;

            return knockScore == 'X' || knockScore == '/' || knockScore == '-' || knockScore == '*';
    }

    private void playBonusRoll(int rollNumber, int frameNumber, char knockScore) {
        BowlingFrame lastBowlingFrame = bowlingFrames.get(NUMBER_OF_FRAMES - 1);
        if(knockScore != '*')
            lastBowlingFrame.getSpareRolls()[frameNumber - NUMBER_OF_FRAMES + rollNumber] = knockScore;
    }

    @Override
    public void notifyObservers() {
        scoreFrames();
    }
}
