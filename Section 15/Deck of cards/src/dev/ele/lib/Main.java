package dev.ele.lib;

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
        // BlackJack game = engine.getGame();
        engine.initGame();
        while (engine.isPlaying()) {
            engine.displayHands();
            engine.play();
            if (!engine.isPlaying()) {
                System.out.println("Game Over, checking winners...");
                engine.displayWinner();
                if (userIO.shouldRestart()) {
                    engine.resetGame();
                } else {
                    System.out.println("Goodbye...");
                }
            }
        }

        userIO.closeScanner();

    }
}