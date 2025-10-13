package dev.ele.model;

import java.util.ArrayList;
import java.util.List;

import dev.ele.utils.Options;

public class Player {

    private List<Card> hand;
    private String name;
    private Options lastOption;
    private final boolean isBot;

    public Player(String name, boolean isBot) {
        this.name = name;
        this.isBot = isBot;
        hand = new ArrayList<>();
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public boolean isBot() {
        return isBot;
    }

    public Options getLastOption() {
        return lastOption;
    }

    public void setLastOption(Options option) {
        lastOption = option;
        // if (option.equals(Options.HIT)) {
        // // handle hit
        // } else if (option.equals(Options.STAND)) {
        // // handle stand
        // }
    }

    public String getName() {
        return name;
    }

    public int getPlayerTotal() {
        int total = 0;
        for (var c : hand) {
            if (c.getFaceValue().equalsIgnoreCase("K") || c.getFaceValue().equalsIgnoreCase("Q")
                    || c.getFaceValue().equalsIgnoreCase("J")) {
                total += 10;
            } else if (c.getFaceValue().equalsIgnoreCase("A")) {
                total += 11;
            } else {
                total += c.getRank() + 2;
            }
        }
        // Check if hand includes an ace and is over 21
        for (var c : hand) {
            if (c.getFaceValue().equalsIgnoreCase("A") && total > 21) {
                // change ace value from 11 to 1
                total -= 10;
            }
        }
        return total;
    }

    public void printPlayerCards() {
        for (var c : hand) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public void printPlayer() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return name + ": " + hand + ", total: " + getPlayerTotal();
    }

}