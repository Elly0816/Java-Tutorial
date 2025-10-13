package dev.ele.utils;

import java.util.List;

import dev.ele.model.Player;

public record BlackJackResult(List<Player> blackjack, List<Player> winner, List<Player> bust,
        List<Player> remainingPlayers) {

    public void printDetailedResult() {

        System.out.println("--------Results--------");
        printBlackJack();
        printWinner();
        printBust();
        printRemainingPlayers();
    }

    private void print(List<Player> item) {
        for (var p : item) {
            System.out.println(p);
        }
        System.out.println();
    }

    public void printBlackJack() {
        if (blackjack().size() > 0) {
            System.out.println("The following player(s) have BlackJack");
            print(blackjack());
        }
    }

    public void printWinner() {
        if (winner().size() > 0) {
            System.out.println("The following player(s) win this round");
            print(winner());
        }
    }

    public void printBust() {
        if (bust().size() > 0) {
            System.out.println("The following player(s) bust in this round");
            print(bust());
        }
    }

    public void printRemainingPlayers() {
        if (remainingPlayers().size() > 0) {
            System.out.println("The remaining player(s) are: ");
            print(remainingPlayers());
        }
    }
}