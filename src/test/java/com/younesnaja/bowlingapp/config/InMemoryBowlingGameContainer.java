package com.younesnaja.bowlingapp.config;

import com.younesnaja.bowlingapp.game.BowlingGame;
import com.younesnaja.bowlingapp.game.impl.TenPinBowlingGame;

public class InMemoryBowlingGameContainer {
    private BowlingGame bowlingGame;

    public InMemoryBowlingGameContainer() {
        bowlingGame = new TenPinBowlingGame();
    }

    public BowlingGame getBowlingGame() {
        return bowlingGame;
    }

    public void initGame() {
        bowlingGame = new TenPinBowlingGame();
    }

    public void setBowlingGame(BowlingGame bowlingGame) {
        this.bowlingGame = bowlingGame;
    }
}
