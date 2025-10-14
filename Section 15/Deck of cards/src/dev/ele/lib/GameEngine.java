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
    private int numberOfPlayers;
    private int currentPlayerTurnIndex = 0;
    private UserIO userIO;

    public GameEngine(int numberOfPlayers, String playerName, UserIO userIO) {
        this.playerName = playerName;
        this.userIO = userIO;
        this.numberOfPlayers = numberOfPlayers;
        game = BlackJack.createGame(numberOfPlayers);
        game.addPlayerToGame(new Player(this.playerName, false));
    }

    public void displayHands() {
        game.printPlayers();
    }

    public void resetGame() {
        System.out.println("\n\nStarting New Game");
        game = BlackJack.createGame(numberOfPlayers);
        game.addPlayerToGame(new Player(playerName, false));
        initGame();
        currentPlayerTurnIndex = 0;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void initGame() {
        Collections.shuffle(game.getPlayers());
        game.dealFirstRound();
        isPlaying = true;
    }

    public BlackJack getGame() {
        return game;
    }

    private int getCurrentPlayerTurnIndex() {
        return currentPlayerTurnIndex;
    }

    private void setNextPlayerTurnIndex() {
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
        System.out.println();
        BlackJackResult result = game.checkForWinner();
        result.printBlackJack();
        result.printBust();
        System.out.println();
        Player currentPlayer = game.getPlayers().get(getCurrentPlayerTurnIndex());
        if (playerCanAct(currentPlayer)) {

            System.out.println(currentPlayer.getName() + "'s turn");
            Random randSleep = new Random();

            if (currentPlayer.isBot()) {
                try {
                    Thread.sleep(randSleep.nextInt(4000));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                Options choice = botRandomChoice();
                System.out.println(currentPlayer.getName() + " chose " + choice.name());
                currentPlayer.setLastOption(choice);
                if (playerLastHit(currentPlayer)) {
                    game.dealSingleCard(currentPlayer);
                }
            } else {
                Options choice = userIO.getUserOption();
                System.out.println(currentPlayer.getName() + " chose " + choice.name());
                currentPlayer.setLastOption(choice);
                if (playerLastHit(currentPlayer)) {
                    game.dealSingleCard(currentPlayer);
                }
            }
        }

        // After each round, check whether to end the game
        if (checkIfAllPlayersBlackJackOrBust() || checkIfAllPlayersStood()) {
            isPlaying = false;
        }
        setNextPlayerTurnIndex();

    }

    private boolean playerLastHit(Player currentPlayer) {
        return currentPlayer.getLastOption().equals(Options.HIT);
    }

    public void displayWinner() {
        System.out.println("Game Over, checking winners...");
        game.checkForWinner().printDetailedResult();
    }

    /**
     * Players can only play if these two conditions are met:
     * 
     * 1) Their total is less than a blackjack.
     * 
     * 2) Either they've not played at all, or their last move was not a stand.
     */
    private boolean playerCanAct(Player currentPlayer) {
        return (currentPlayer.getLastOption() == null || !currentPlayer.getLastOption().equals(Options.STAND))
                && currentPlayer.getPlayerTotal() < BlackJack.BLACKJACK;
    }

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