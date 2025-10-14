package dev.ele.utils;

import dev.ele.model.BlackJack;

public class CalculateScores {

    private BlackJack game;

    public CalculateScores(BlackJack game) {
        this.game = game;
    }

    public void printResult() {
        System.out.println("Game Over, checking winners...");
        game.checkForWinner().printDetailedResult();
    }

    public void printCurrentBlackJackAndBust() {
        System.out.println();
        game.checkForWinner().printBlackJack();
        game.checkForWinner().printBust();
    }
}