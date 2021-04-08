//package com.younesnaja.bowlingapp.impl;
//
//import com.younesnaja.bowlingapp.BowlingFrame;
//
//public class OpenBowlingFrame extends AbstractBowlingFrame {
//
//    public OpenBowlingFrame(char knockScore) {
//        firstRoll = knockScore;
//    }
//
//    public OpenBowlingFrame() {
//    }
//
//    @Override
//    public void scoreFrame() {
//        frameScore = Integer.sum(scoreSymbolsToInt(firstRoll), scoreSymbolsToInt(secondRoll));
//    }
//
//    @Override
//    public void addSpareFrame(BowlingFrame bowlingFrame) {
//            spareRolls[0] = bowlingFrame.getFirstRoll();
//            spareRolls[1] = bowlingFrame.getSecondRoll();
//    }
//
//    @Override
//    public boolean isDone() {
//        return isDone;
//    }
//
//    @Override
//    public FrameTypes getFrameType() {
//        return FrameTypes.OPEN;
//    }
//
//    public void setIsDone(boolean isDone) {
//        this.isDone = isDone;
//    }
//
//    @Override
//    public int getLeftRolls() {
//        return leftRolls;
//    }
//}
