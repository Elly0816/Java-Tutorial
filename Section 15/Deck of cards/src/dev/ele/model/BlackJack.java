package dev.ele.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dev.ele.utils.BlackJackResult;

public class BlackJack {

    private Deck deck;
    private List<Player> players;
    private static String[] names = { "Liam", "Ava", "Noah", "Zoe", "Ethan", "Mia", "Lucas", "Lily", "Mason", "Grace",
            "Oliver", "Chloe", "Elijah", "Ruby", "Henry", "Isla", "Leo", "Nora", "Jack", "Stella" };
    public static final int BLACKJACK = 21;
    private int currentPlayerTurnIndex = 0;
    // private boolean shouldPlay;

    private BlackJack(List<Player> players) {
        this.deck = new Deck();
        this.players = players;
        // shouldPlay = true;
    }

    public static BlackJack createGame(int numberOfPlayers) {
        BlackJack game = new BlackJack(createPlayers(numberOfPlayers));
        return game;
    }

    public int getCurrentPlayerTurnIndex() {
        return currentPlayerTurnIndex;
    }

    public void setNextPlayerTurnIndex() {
        currentPlayerTurnIndex = (++currentPlayerTurnIndex) % (getNumberOfPlayers());
    }

    private static List<Player> createPlayers(int amount) {
        List<Player> players = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < amount; i++) {
            String randomName = names[rand.nextInt(names.length)];
            players.add(new Player(randomName, true));
        }
        return players;
    }

    public void addPlayerToGame(Player player) {
        players.add(player);
    }

    public Deck getDeck() {
        return deck;
    }

    // public boolean shouldPlay() {
    // return shouldPlay;
    // }

    // public void stopGame() {
    // shouldPlay = false;
    // }

    public List<Player> getPlayers() {
        return players;
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    // public int getCurrentPlayerTurnIndex() {
    // return currentPlayerTurnIndex;
    // }

    // public void setNextPlayerTurnIndex() {
    // currentPlayerTurnIndex = (++currentPlayerTurnIndex) % (getNumberOfPlayers());
    // }

    /**
     * 
     * Player specific game methods
     * 
     * 
     */

    public void dealFirstRound() {
        deck.shuffle();
        dealCards(2);
    }

    public void dealSingleCard(int playerIndex) {
        dealSingleCard(players.get(playerIndex));
    }

    public void dealSingleCard(Player player) {
        player.addToHand(deck.getCardFromDeck());
    }

    public void dealCards(int amount) {
        for (int i = 0; i < amount; i++)
            for (var p : players) {
                p.addToHand(deck.getCardFromDeck());
            }
    }

    public Player getPlayer(int playerIndex) {
        if (playerIndex >= players.size()) {
            return null;
        }
        return players.get(playerIndex);
    }

    public void printPlayers() {
        System.out.println("-----Players in game-----");
        for (var p : players) {
            System.out.println(p);
        }
    }

    /**
     * 
     * Game specific methods
     * 
     * 
     */
    public BlackJackResult checkForWinner() {
        List<Player> blackJacks = new ArrayList<>();
        List<Player> winners = new ArrayList<>();
        List<Player> busts = new ArrayList<>();
        boolean foundWinner = false;
        // boolean foundBust = false;
        for (var p : players) {
            // check for players with rank total over 21
            int playerTotal = p.getPlayerTotal();
            if (playerTotal == BLACKJACK) {
                // System.out.println(
                // "player " + players.indexOf(p) + " had total " + playerTotal
                // + " and has blackjack with cards: ");
                // p.printPlayerCards();
                blackJacks.add(p);
                foundWinner = true;
            } else if (playerTotal > BLACKJACK) {
                // System.out
                // .println("player " + players.indexOf(p) + " had total " + playerTotal
                // + " and busts with cards: ");
                // p.printPlayerCards();
                busts.add(p);
                // foundBust = true;
            }
        }
        // If no blackjack, find the player with the highest total;
        if (!foundWinner) {
            int maxBelowBlackJack = 0;
            Player winner = null;
            for (var p : players) {
                int playerTotal = p.getPlayerTotal();
                if (playerTotal >= maxBelowBlackJack && playerTotal < BLACKJACK) {
                    maxBelowBlackJack = playerTotal;
                    winner = p;
                }
            }
            winners.add(winner);
            // Check for multiple winners
            for (var p : players) {
                if (winner.getPlayerTotal() == p.getPlayerTotal() && !p.equals(winner)) {
                    winners.add(p);
                }
            }

            if (winners.size() > 1) {
                // System.out.println(
                // "There has been a tie between " + (winners.size() + 1) + " players with total
                // "
                // + maxBelowBlackJack);
                // winner.printPlayerCards();
                for (var p : winners) {
                    // p.printPlayerCards();
                }
            } else {
                // System.out.println("Player " + players.indexOf(winner) + " has total " +
                // winner.getPlayerTotal()
                // + " and is the winner with cards: ");
                // winner.printPlayerCards();
            }

        }

        List<Player> remainingPlayers = new ArrayList<>();
        for (var p : players) {
            if (!winners.contains(p) && !busts.contains(p) && !blackJacks.contains(p)) {
                remainingPlayers.add(p);
            }
        }

        return new BlackJackResult(blackJacks, winners, busts, remainingPlayers);
    }
}