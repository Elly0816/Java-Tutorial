package dev.ele.lib;

import dev.ele.utils.CalculateScores;
import dev.ele.utils.UserIO;

public class Main {
    public static void main(String[] args) {

        System.out.println("----------------Welcome to BlackJack----------------");
        System.out.print("Please enter your name: ");
        UserIO userIO = new UserIO();
        String userName = userIO.getUserName();
        System.out.print("Hi " + userName + "!\nHow many players would you want to play against? (Max 6 players): ");
        int numberOfOpponents = userIO.getNumberOfOpponents();
        GameEngine engine = new GameEngine(numberOfOpponents, userName, userIO);
        CalculateScores scorer = new CalculateScores(engine.getGame());
        engine.initGame();
        userIO.setGame(engine.getGame());
        while (engine.isPlaying()) {
            // Print player hands
            userIO.printPlayers();
            // Print players that currently have blackjack or have bust
            scorer.printCurrentBlackJackAndBust();
            // Execute current player choice
            engine.play();
            if (!engine.isPlaying()) {
                // engine.displayWinner();
                scorer.printResult();
                if (userIO.shouldRestart()) {
                    engine.resetGame();
                    scorer = new CalculateScores(engine.getGame());
                    userIO.removeGame();
                    userIO.setGame(engine.getGame());
                } else {
                    System.out.println("Goodbye...");
                }
            }
        }

        userIO.closeScanner();

    }
}