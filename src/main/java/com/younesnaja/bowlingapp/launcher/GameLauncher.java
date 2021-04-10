package com.younesnaja.bowlingapp.launcher;

import com.younesnaja.bowlingapp.exception.InvalidKnockedPinsNumber;
import com.younesnaja.bowlingapp.exception.MaxKnockedPinsExceededException;
import com.younesnaja.bowlingapp.exception.NumberOfRollsNotAllowedException;
import com.younesnaja.bowlingapp.game.BowlingGame;
import com.younesnaja.bowlingapp.game.impl.TenPinBowlingGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameLauncher {
    private static BowlingGame bowlingGame;
    private static List<String> headerTitles = Arrays.asList(new String[]{"1st Roll", "2nd Roll", "Score"});
    private static Scanner consoleScanner;

    public static void play() {
        consoleScanner = new Scanner(System.in);
        bowlingGame = new TenPinBowlingGame();

        for (int i = 0; i < bowlingGame.getNumberOfFrames(); i++) {
            System.out.println(String.format("-> Turn %d : ", i + 1));
            roll(i, 0, "Enter the number of points in the %s roll : ");
            if(i == bowlingGame.getNumberOfFrames() - 1){
                int leftRolls = bowlingGame.getBowlingFrames().get(bowlingGame.getNumberOfFrames() - 1).getLeftRolls();
                for(int j = 0; j < leftRolls; j++){
                    roll(bowlingGame.getNumberOfFrames(), j, "Enter the number of points in the %s bonus roll : ");
                }
            }
            printScore();
        }
    }

    private static void roll(int frameNumber, int rollNumber, String message) {
        for(int i = rollNumber; i < 2; i++){
            try {
                String rollN = i == 0 ? "1st" : "2nd";
                System.out.print(String.format(message, rollN));
                String rollScore = consoleScanner.nextLine();
                bowlingGame.roll(frameNumber, i, rollScore);
            } catch (MaxKnockedPinsExceededException maxKnockedPinsExceededException) {
                System.err.print(maxKnockedPinsExceededException.getMessage());
                roll(frameNumber, i, message);
            } catch (NumberOfRollsNotAllowedException numberOfRollsNotAllowedException) {
                System.err.print(numberOfRollsNotAllowedException.getMessage());
            } catch (InvalidKnockedPinsNumber invalidKnockedPinsNumber) {
                System.err.print(invalidKnockedPinsNumber.getMessage());
                roll(frameNumber, i, message);
            }
        }
    }

    private static void printScore() {
        int gameScore;
        StringBuilder scoreBoard = new StringBuilder();

        headerTitles.stream().forEach(headerTitle -> scoreBoard.append(String.format("| %s ", headerTitle)));
        scoreBoard.append("|\n");

        for (int i = 0; i <= bowlingGame.getTurnNumber(); i++) {
            scoreBoard.append(String.format("|%s", " ".repeat(headerTitles.get(0).length() + 1)));
            scoreBoard.append(bowlingGame.getBowlingFrames().get(i).getFirstRoll());

            scoreBoard.append(String.format("|%s", " ".repeat(headerTitles.get(1).length() + 1)));
            scoreBoard.append(bowlingGame.getBowlingFrames().get(i).getSecondRoll());

            if(i == 0) {
                gameScore = bowlingGame.scoreGame();
                scoreBoard.append(String.format("|%s", " ".repeat(headerTitles.get(2).length() - String.valueOf(gameScore).length() + 2)));
                scoreBoard.append(gameScore);
                scoreBoard.append("|\n");
            } else {
                scoreBoard.append("|\n");
            }
        }
        System.out.print(scoreBoard);
    }
}
