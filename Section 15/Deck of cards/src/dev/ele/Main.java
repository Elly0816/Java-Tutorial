package dev.ele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dev.ele.model.Card;
import dev.ele.model.Card.Face;
import dev.ele.model.Card.Suit;

/**
 * 
 * In order to render the glyphs, use windows terminal
 * 
 * use chcp 65001 on the terminal
 * 
 */

public class Main {
    public static void main(String[] args) {

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, Card.Face.ACE);
        // The static fill() method assigns a value to all entries in the array
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck("Ace of Hearts", Arrays.asList(cardArray), 1);

        List<Card> cards = new ArrayList<>(52);

        // the fill() method replaces every element on the list with the specified
        // object. Note that the collection must not be empty becuase the method
        // REPLACES items
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards);
        System.out.println("cards.size() = " + cards.size());

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck("Aces of Hearts", acesOfHearts, 1);

        Card kingOfClubs = Card.getFaceCard(Suit.CLUB, Face.KING);
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck("Kings of Clubs", kingsOfClubs, 1);

        // addAll() method on collections adds multiple elements to the end of the
        // collection
        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);
        Card.printDeck("With collections.addAll", cards, 2);

        Collections.copy(cards, kingsOfClubs);// Copies content to destination from source. If the destination is
                                              // smaller in size from the source, you get an indexOutOfBounds error. But
                                              // if the destination is larger than the source, it overwrites elements.
                                              // Note that the index of elements stary the same from the source to the
                                              // destination. This operation happens in place of course.
        Card.printDeck("Card collection with kings copied", cards, 2);

        cards = List.copyOf(kingsOfClubs); // A copy of the list is returned
        Card.printDeck(cards);

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck("This is a standard deck", deck, 4);

        // Shuffle method on Collections
        Collections.shuffle(deck);
        Card.printDeck("This is a shuffled deck", deck, 4);

        // Sorting with comparable
        Collections.sort(deck);
        Card.printDeck("This is a sorted deck using the comparable interface", deck, 4);

        // Sorting with comparator
        Comparator<Card> sorter = Comparator.comparing(Card::getRank).thenComparing(Card::getSuitChar);
        Collections.sort(deck, sorter);
        Card.printDeck("Standard deck sorted by rank and then suit", deck, 13);
        Collections.reverse(deck);
        Card.printDeck("Standard deck reversed", deck, 13);

        // Creating sublists
        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck("Kings in the deck", kings, 1);

        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck("Tens in the deck", tens, 1);

        // Operations with sublists
        int subListIndex = Collections.indexOfSubList(deck, tens);// This returns the starting index of a sublist
        System.out.println("Sublist index for tens = " + subListIndex);// The elements have to appear in order and in a
                                                                       // contiguous block
        System.out.println("Contains = " + deck.containsAll(tens));// Can appear in any order

        // Disjointing (Checks if two collections have no elements in common)
        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("disjoint = " + disjoint);

        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("disjoint = " + disjoint2);

        // Binary Search static method on Collections
        Card tenOfHearts = Card.getFaceCard(Suit.HEART, Face.TEN);
        // deck.sort(Comparator.naturalOrder());
        deck.sort(sorter);
        /*
         * Note that the binarySearch method performs better on large sorted
         * collections, otherwise, just use indexOf or lastIndexOf
         */
        // int foundIndex = Collections.binarySearch(deck, tenOfHearts,
        // Comparator.naturalOrder());// Collection has to be
        int foundIndex = Collections.binarySearch(deck, tenOfHearts);// Collection has to be
                                                                     // sorted in
                                                                     // ascending/natural
        // order in order to accurately use this method
        System.out.println(tenOfHearts + " was found at index " + foundIndex);
        /*
         * This method is needed because the equals() method in classes are reference
         * based and two objects of the same class would have different hashCode()
         * regardless of the values contained, while the equals() on records are value
         * based and two records with the same field values would have the same
         * hashCode()
         */
        int secondFoundIndex = indexOfCard(tenOfHearts, deck);
        // The equals() and hashCode() methods have been overriden, so this can be used
        secondFoundIndex = deck.indexOf(tenOfHearts);
        System.out.println("foundIndex: " + secondFoundIndex);
        System.out.println(deck.get(secondFoundIndex));
        System.out.println(deck.get(foundIndex));
        Card.printDeck(deck);

        // Collections replaceAll
        Card tenOfClubs = Card.getFaceCard(Suit.CLUB, Face.TEN);
        Collections.replaceAll(deck, tenOfClubs, tenOfHearts);
        Card.printDeck("Tens row", deck.subList(32, 36), 1);
        Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
        Card.printDeck("Tens row", deck.subList(32, 36), 1);

        if (Collections.replaceAll(deck, tenOfHearts, tenOfClubs)) {
            System.out.println("Tens of hearts replaced with tens of clubs");
        } else {
            System.out.println("No tens of hearts found in the list");
        }

        // Collections frequency that allows checking for duplicates
        System.out.println("Tens of clubs card = " + Collections.frequency(deck, tenOfClubs));

        // Collections min & Collections max checks the returns the min and max entries
        // in the collection based on the natural ordering
        System.out.println("The maximum card in the deck is: " + Collections.max(deck));
        System.out.println("The minimum card in the deck is: " + Collections.min(deck));

        // Rotate method
        var sortBySuit = Comparator.comparing(Card::getSuitChar).thenComparing(Card::getRank);
        deck.sort(sortBySuit);
        Card.printDeck("Sorted by Suit and then Rank", deck, 4);

        List<Card> copy = new ArrayList<>(deck.subList(0, 13));
        Card.printDeck("Unrotated List", copy, 1);
        Collections.rotate(copy, 2);
        Card.printDeck("Rotated List with distance 2: ", copy, 1);

        List<Card> copy2 = new ArrayList<>(deck.subList(0, 13));
        Card.printDeck("Unrotated List2", copy2, 1);
        Collections.rotate(copy2, -2);
        Card.printDeck("Rotated List2 with distance -2: ", copy2, 1);

        // Swapping elements with Collections.swap()
        List<Card> copy3 = new ArrayList<>(deck.subList(0, 13));
        Card.printDeck("Before swapping", copy3, 1);
        for (int i = 0; i < copy3.size() / 2; i++) {
            // var temp = copy3.get(i);
            // int rearIndex = copy3.size() - 1 - i;
            // copy3.set(i, copy3.get(rearIndex));
            // copy3.set(rearIndex, temp);
            Collections.swap(copy3, i, copy3.size() - 1 - i);
        }
        Card.printDeck("After swapping", copy3, 1);

        // Reversing the collection with Collections.reverse()
        copy3 = new ArrayList<>(deck.subList(0, 13));
        Card.printDeck("Before reversing", copy3, 1);
        Collections.reverse(copy3);
        Card.printDeck("After reversing", copy3, 1);
    }

    private static int indexOfCard(Card c, List<Card> l) {
        int i = 0;
        for (var item : l) {
            if (item.getFaceValue().equals(c.getFaceValue()) && item.getRank() == c.getRank()
                    && item.getSuitChar() == c.getSuitChar()) {
                return i;
            }
            i++;
        }
        return -1;
    }
}