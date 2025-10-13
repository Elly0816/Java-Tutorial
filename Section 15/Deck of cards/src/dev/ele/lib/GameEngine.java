package dev.ele.lib;

import java.util.Collections;
import java.util.Random;

import dev.ele.model.BlackJack;
import dev.ele.model.Player;
import dev.ele.utils.BlackJackResult;
import dev.ele.utils.Options;
import dev.ele.utils.UserIO;

public class GameEngine {
    private BlackJack game;
    private String playerName;
    private boolean isPlaying;
    private int currentPlayerTurnIndex = 0;

    public GameEngine(int numberOfPlayers, String playerName) {
        this.playerName = playerName;
        game = BlackJack.createGame(numberOfPlayers);
        game.addPlayerToGame(new Player(this.playerName, false));
    }

    public void displayHands() {
        game.printPlayers();
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void initGame() {
        isPlaying = true;
        game.dealFirstRound();
        Collections.shuffle(game.getPlayers());
    }

    public int getCurrentPlayerTurnIndex() {
        return currentPlayerTurnIndex;
    }

    public void setNextPlayerTurnIndex() {
        currentPlayerTurnIndex = (++currentPlayerTurnIndex) % (game.getNumberOfPlayers());
    }

    private Options botRandomChoice() {
        Random rand = new Random();
        int choice = rand.nextInt(Options.values().length);
        // Bot is playing randomly

        return Options.values()[choice];
    }

    public void play() {
        // Each player should get a turn to pick hit/stand
        game.printPlayers();
        System.out.println();
        BlackJackResult result = game.checkForWinner();
        result.printBlackJack();
        result.printBust();
        System.out.println();
        Player currentPlayer = game.getPlayers().get(getCurrentPlayerTurnIndex());
        /**
         * Players can only play if these two conditions are met
         * 1) Their total is less than a blackjack
         * 
         * 2) Either they've not played at all, or their last move was not a stand
         */
        if ((currentPlayer.getLastOption() == null || !currentPlayer.getLastOption().equals(Options.STAND))
                && currentPlayer.getPlayerTotal() < BlackJack.BLACKJACK) {

            System.out.println(currentPlayer.getName() + "'s turn");
            if (currentPlayer.isBot()) {
                Options choice = botRandomChoice();
                System.out.println(currentPlayer.getName() + " chose " + choice.name());
                currentPlayer.setLastOption(choice);
                if (currentPlayer.getLastOption().equals(Options.HIT)) {
                    currentPlayer.addToHand(game.getDeck().getCardFromDeck());
                }
            } else {
                Options choice = UserIO.getUserOption();
                System.out.println(currentPlayer.getName() + " chose " + choice.name());
                currentPlayer.setLastOption(choice);
                if (currentPlayer.getLastOption().equals(Options.HIT)) {
                    currentPlayer.addToHand(game.getDeck().getCardFromDeck());
                }
            }
        }
        // Display cards
        // game.printPlayers();

        // After each round, check if who's winning
        if (checkIfAllPlayersBlackJackOrBust() || checkIfAllPlayersStood()) {
            isPlaying = false;
            System.out.println("Game Over, checking winners...");
            game.checkForWinner().printDetailedResult();
            return;
        }
        if (!isPlaying) {
            System.out.println("Game Over, checking winners...");
            game.checkForWinner().printDetailedResult();
            return;
        }
        setNextPlayerTurnIndex();

    }

    // public void checkForWinner() {
    // BlackJackResult result = game.checkForWinner();
    // if (result.blackjack().size() > 0) {
    // isPlaying = false;
    // }
    // result.printDetailedResult();
    // }

    private boolean checkIfAllPlayersStood() {
        for (var p : game.getPlayers()) {
            if (p.getPlayerTotal() < BlackJack.BLACKJACK
                    && (p.getLastOption() == null || p.getLastOption().equals(Options.HIT))) {
                return false;
            }
        }
        System.out.println("All players have either stood, have blackjack or have bust");
        return true;
    }

    private boolean checkIfAllPlayersBlackJackOrBust() {
        BlackJackResult result = game.checkForWinner();
        if (result.blackjack().size() + result.bust().size() == game.getNumberOfPlayers()) {
            System.out.println("All players have either blackjack or have bust");
            return true;
        }
        return false;
    }

}