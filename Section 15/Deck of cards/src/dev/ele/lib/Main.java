package dev.ele.lib;

import dev.ele.utils.UserIO;

public class Main {
    public static void main(String[] args) {
        UserIO.startScanner();

        System.out.println("----------------Welcome to BlackJack----------------");
        System.out.print("Please enter your name: ");
        String userName = UserIO.getUserName();
        System.out.print("Hi " + userName + "!\nHow many players would you want to play against? (Max 6 players): ");
        int numberOfOpponents = UserIO.getNumberOfOpponents();
        GameEngine game = new GameEngine(numberOfOpponents, userName);

        game.initGame();
        while (game.isPlaying()) {
            game.play();
        }

        UserIO.closeScanner();

    }
}