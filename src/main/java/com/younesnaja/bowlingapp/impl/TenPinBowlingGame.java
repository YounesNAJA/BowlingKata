package com.younesnaja.bowlingapp.impl;

import com.younesnaja.bowlingapp.BowlingFrame;
import com.younesnaja.bowlingapp.BowlingGame;

import java.util.ArrayList;
import java.util.List;

public class TenPinBowlingGame extends BowlingGame {
    public TenPinBowlingGame() {
        super(10, 2);
        bowlingFrames = new ArrayList<BowlingFrame>(NUMBER_OF_FRAMES){{
            for (int i = 0; i < NUMBER_OF_FRAMES; i++) {
                add(new BowlingFrame() {
                    @Override
                    public char getFirstRoll() {
                        return 0;
                    }

                    @Override
                    public void setFirstRoll(char firstRoll) {

                    }

                    @Override
                    public void setSecondRoll(char secondRoll) {

                    }

                    @Override
                    public char getSecondRoll() {
                        return 0;
                    }

                    @Override
                    public void scoreFrame() {}

                    @Override
                    public int getScore() {
                        return 0;
                    }

                    @Override
                    public int getLeftRolls() {
                        return 0;
                    }

                    @Override
                    public void setFrameType(AbstractBowlingFrame.FrameTypes frameType) {

                    }

                    @Override
                    public void setLeftRolls(int leftRolls) {

                    }

                    @Override
                    public char[] getSpareRolls() {
                        return new char[2];
                    }

                    @Override
                    public void addSpareFrame(BowlingFrame bowlingFrame) {

                    }

                    @Override
                    public AbstractBowlingFrame.FrameTypes getFrameType() {
                        return AbstractBowlingFrame.FrameTypes.OPEN;
                    }

                    @Override
                    public int scoreSymbolsToInt(char scoreSymbol) {
                        return 0;
                    }

                    @Override
                    public void addSpareRolls(List<BowlingFrame> bowlingFrames) {

                    }
                });
            }
        }};
    }

    public int getBonusRolls() {
        return bowlingFrames.get(NUMBER_OF_FRAMES - 1).getLeftRolls();
    }

    public int score() {
        scoreFrames();
        return bowlingFrames.stream().mapToInt(BowlingFrame::getScore).sum();
    }

    private void scoreFrames() {
        if(/*isDone()*/true){
            bowlingFrames.forEach(bowlingFrame -> bowlingFrame.addSpareRolls(bowlingFrames));
            for (int i = 0; i <= turnNumber; i++) {
                /*if(bowlingFrames.get(i).getFirstRoll() == 'X') {
                    //bowlingFrames.get(i).addSpareFrame(bowlingFrames.get(i).getSpareRolls()[0], bowlingFrames.get(i).getSpareRolls()[1]);
                    bowlingFrames.get(i).addSpareRolls(bowlingFrames);
                } else if(bowlingFrames.get(i).getScore() == 10) {
                }
*/
                bowlingFrames.get(i).addSpareRolls(bowlingFrames);
                bowlingFrames.get(i).scoreFrame();
            }
        }
    }

    public void setFrames(List bowlingFrames) {
        this.bowlingFrames = bowlingFrames;
    }

    @Override
    public void roll(int frameNumber, int rollNumber, String knockScore) {
        if(frameNumber <= NUMBER_OF_FRAMES - 1) {
            this.turnNumber = frameNumber;
            //if(rollNumber <= 1) {
            BowlingFrame bowlingFrame = new SpareBowlingFrame(frameNumber);
            if(knockScore.charAt(0) == 'X')
                bowlingFrame.setFrameType(AbstractBowlingFrame.FrameTypes.STRIKE);
            else
                bowlingFrame.setFrameType(AbstractBowlingFrame.FrameTypes.SPARE);

            if(rollNumber == 0)
                bowlingFrame.setFirstRoll(knockScore.charAt(0));
            else if(rollNumber == 1)
                bowlingFrame.setSecondRoll(knockScore.charAt(0));

            bowlingFrames.set(turnNumber, bowlingFrame);
        }


            /*if(rollNumber == 1
                    && Integer.sum(
                            bowlingFrames.get(frameNumber).scoreSymbolsToInt(bowlingFrames.get(frameNumber).getFirstRoll()),
                            bowlingFrames.get(frameNumber).scoreSymbolsToInt(bowlingFrames.get(frameNumber).getSecondRoll())
            ) == 10) {
                bowlingFrames.set(frameNumber, (SpareBowlingFrame) bowlingFrames.get(frameNumber));
            }*/
       // } else {
            if(frameNumber > NUMBER_OF_FRAMES) {
                BowlingFrame lastBowlingFrame = bowlingFrames.get(NUMBER_OF_TURNS - 1);
                lastBowlingFrame.getSpareRolls()[frameNumber - NUMBER_OF_FRAMES - 1] = knockScore.charAt(0);
            }
        //}

        //if(isDone)
            scoreFrames();
    }

    @Override
    public boolean isDone() {
        return isDone;
    }
}
