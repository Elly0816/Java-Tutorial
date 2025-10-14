package dev.ele.model;

import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> deck;

    public Deck() {
        deck = Card.getStandardDeck();
    }

    public void shuffle() {
        System.out.println("Shuffling deck");
        Collections.shuffle(deck);
        System.out.println("Deck shuffled");
    }

    // public void printDeck() {
    // System.out.println("-----Cards in Deck-----");
    // Card.printCards(deck);
    // }

    // public void printDeck(String description, int numberOfRows) {
    // Card.printCards(description, deck, numberOfRows);
    // }

    public Card getCardFromDeck() {
        if (deck.size() == 0) {
            return null;
        }
        return deck.remove(deck.size() - 1);
    }

    @Override
    public String toString() {
        return "Deck: " + deck;
    }

}